package com.ghouse.beamer.util;

import java.util.concurrent.TimeUnit;

public class ThreadUtil {
    public static void waiter(int value, TimeUnit timeUnit){
        try {
            long sleepTimeMs = timeUnit.toMillis(value);
            Thread.sleep(sleepTimeMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
