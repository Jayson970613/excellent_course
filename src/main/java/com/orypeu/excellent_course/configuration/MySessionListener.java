package com.orypeu.excellent_course.configuration;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MySessionListener
 * @Description TODO
 * @Author LJH
 * @Date 2020/1/21 17:21
 * @Version 1.0
 */
public class MySessionListener implements SessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();

    }

    public int getSessionCount() {
        return sessionCount.get();
    }

}
