package com.kcss.core.util.common;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Date 2018/8/13 15:31
 */
public class HttpClientUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private static final String CHARSET = "UTF-8";
    private static final String APPLICATION_JSON = "application/json";

    private static CloseableHttpClient getHttpClient() {
        int nMaxTotal = 400;
        int nDefaultMaxPerRoute = 200;

        // 连接池参数详细配置
        PoolingHttpClientConnectionManager phcm = new PoolingHttpClientConnectionManager();
        // 最大连接数
        phcm.setMaxTotal(nMaxTotal);
        // 每个路由基础的连接
        phcm.setDefaultMaxPerRoute(nDefaultMaxPerRoute);

        return HttpClients.custom().setConnectionManager(phcm).build();
    }

    public static CloseableHttpResponse doGet(String url){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpGet httpget = null;
        try {
            httpClient = getHttpClient();

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(10*1000)//设置连接超时时间
                    .setConnectionRequestTimeout(10*1000)//设置请求超时时间
                    .setSocketTimeout(10*1000)
                    .setRedirectsEnabled(true)//默认允许自动重定向
                    .build();

            //创建httpget
            httpget = new HttpGet(url);
            httpget.setConfig(requestConfig);

            logger.info("executing request " + httpget.getURI());
            //执行get请求
            response = httpClient.execute(httpget);


        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }finally{
            try {
                if(httpClient != null){
                    httpClient.close();
                }
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
        }
        return response;

    }

    /**
     * http post请求
     *
     * @param url
     *            请求地址
     * @param params
     *            请求参数
     * @return
     */
    public static String doPost(String url, String params) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = getHttpClient();

            HttpPost httpPost = new HttpPost(url);
            StringEntity sEntity = new StringEntity(params, CHARSET);
            httpPost.setEntity(sEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                return EntityUtils.toString(entity, CHARSET);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }finally{
            try {
                if(httpClient != null){
                    httpClient.close();
                }
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
        }
        return null;
    }

    public static String doPostForJSON(String url, String json){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = getHttpClient();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
            StringEntity sEntity = new StringEntity(json, CHARSET);
            sEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            httpPost.setEntity(sEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                return EntityUtils.toString(entity, CHARSET);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }finally{
            try {
                if(httpClient != null){
                    httpClient.close();
                }
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int times = 100;
        final CountDownLatch latch = new CountDownLatch(times);

        System.out.println("<<<<<<开始>>>>>>");
        long startTime = System.currentTimeMillis();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < times; i++) {
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        CloseableHttpResponse response = HttpClientUtil.doGet("http://192.168.46.101:8891/review?loanAppId=100175");
                        if(response!=null){
                            System.out.println(response.getStatusLine().getStatusCode());
                        }

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("<<<<<<共计用时"+(System.currentTimeMillis()-startTime)/1000+"秒>>>>>>");
        System.out.println("<<<<<<平均用时"+(System.currentTimeMillis()-startTime)/(1000*times)+"秒>>>>>>");
        System.out.println("<<<<<<结束>>>>>>");
        fixedThreadPool.shutdown();
    }
}
