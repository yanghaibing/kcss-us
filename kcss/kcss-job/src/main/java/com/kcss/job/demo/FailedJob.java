package com.kcss.job.demo;

import com.kcss.job.BaseJob;
import org.springframework.stereotype.Service;

@Service
public class FailedJob implements BaseJob {
    @Override
    public void run() {
        System.out.println("failed");
        throw new RuntimeException("failed");
    }
}
