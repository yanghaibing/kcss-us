package com.kcss.monitor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcss.monitor.entity.AlertMessageEntity;
import com.kcss.monitor.spec.AlertMessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Map;

@Service
@ConditionalOnProperty("kcss.monitor.enabled")
public class MonitorService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${kcss.monitor.environment.from}")
    private String from;
    @Value("${kcss.monitor.environment.keywords}")
    private String keywords;
    @Autowired
    RestTemplate monitorRestTemplate;
    @Value("${kcss.monitor.report.url}")
    private String monitorUrl;
    @Value("${kcss.monitor.report.rest.api.message.template}")
    private String restApiMessageQueryString;
    @Value("${kcss.monitor.report.error.only}")
    private Boolean isReportErrorOnly;

    @SuppressWarnings("unchecked")
    @Scheduled(cron = "${kcss.monitor.report.cron}")
    public void postAlertMessage() {
        AlertMessageEntity currentEntity = null;
        while ((currentEntity = MessageCollection.poll()) != null) {
            try {
                HttpHeaders headers = new HttpHeaders();
                Long timestamp = Instant.now().toEpochMilli();
                headers.set("M-FROM", from);
                headers.set("M-KEYWORDS", keywords);
                headers.set("M-TS", timestamp.toString());
                headers.set("M-SIGNATURE", EncryptUtils.encryptSha256(new StringBuilder(from).append(keywords).append(timestamp).toString()));
                Map<String, Object> urlParams = new ObjectMapper().convertValue(currentEntity, Map.class);
                urlParams.put("traceFrom", from);
                urlParams.put("startTime", currentEntity.getStartTime().toString());
                urlParams.put("endTime", currentEntity.getEndTime().toString());
                monitorRestTemplate.postForObject(monitorUrl + restApiMessageQueryString, new HttpEntity<>(currentEntity, headers), String.class, urlParams);
            } catch (Exception e) {
                logger.warn("report error: {} ", e.getMessage(), e);
            }
        }
    }

    public void collectMessage(AlertMessageEntity alertMessageEntity) {
        if (isReportErrorOnly) {
            if (alertMessageEntity.getType().equals(AlertMessageType.fail)) {
                MessageCollection.add(alertMessageEntity);
            }
        } else {
            MessageCollection.add(alertMessageEntity);
        }
    }

}
