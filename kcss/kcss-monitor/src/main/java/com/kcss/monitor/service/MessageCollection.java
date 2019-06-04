package com.kcss.monitor.service;

import com.kcss.monitor.entity.AlertMessageEntity;

import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageCollection {
    private final static ConcurrentLinkedQueue<AlertMessageEntity> queues = new ConcurrentLinkedQueue<>();
    private static final long limitation = 100000;

    protected static void add(AlertMessageEntity alertMessageEntity) {
        try {
            if (queues.size() < limitation) {
                queues.add(alertMessageEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException("alertMessageEntity add error", e);
        }
    }

    protected static AlertMessageEntity poll() {
        try {
            return queues.poll();
        } catch (Exception e) {
            throw new RuntimeException("alertMessageEntity poll error", e);
        }
    }

}
