package com.kcss.job.demo;

import com.kcss.job.BaseJob;

import org.springframework.stereotype.Service;

/**
 * Create by  on 2019/6/3 10:04
 * Description:
 */
@Service
public class Demo implements BaseJob {
    @Override
    public void run() {
        System.out.println("demo run");
    }
}
