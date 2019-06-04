package com.kcss.biz.file;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

@Component
public class AliyunOssWrapper implements FileWrapper {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private OSS oss;
    @Value("${aliyun.oss.bucket}")
    private String bucketName;

    @Override
    public void upload(InputStream inputStream, String filePath) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            byte[] fileBytes = IOUtils.toByteArray(inputStream);
            metadata.setContentLength(fileBytes.length);
            metadata.setObjectAcl(CannedAccessControlList.Private);
            oss.putObject(new PutObjectRequest(bucketName, filePath, new ByteArrayInputStream(fileBytes), metadata));
            IOUtils.closeQuietly(inputStream);
        } catch (IOException e) {
            logger.error("oss upload file error", e);
            throw new FileException(String.format("upload file error, caused by %s", e.getMessage()));
        }
    }

    @Override
    public void copyTo(String filePath, OutputStream outputStream) {
        try {
            InputStream inputStream = oss.getObject(bucketName, filePath).getObjectContent();
            IOUtils.copy(inputStream, outputStream);
            IOUtils.closeQuietly(inputStream);
        } catch (Throwable e) {
            logger.error("oss copy file error", e);
            throw new FileException(String.format("copy file error, caused by %s", e.getMessage()));
        }
    }

    @Override
    public String getFileUrl(String filePath) {
        return getFileUrl(filePath, System.currentTimeMillis() + 60 * 60 * 1000);
    }

    private String getFileUrl(String filePath, long expirationInMillisecond) {
        Date expiration = new Date();
        expiration.setTime(expirationInMillisecond);
        return oss.generatePresignedUrl(bucketName, filePath, expiration).toString();
    }
}
