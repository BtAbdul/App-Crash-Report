package com.btabdul.crash;

import android.content.Context;
import android.content.Intent;

public class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Context context;

    public CustomExceptionHandler(Context context) {
        this.context = context;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        // Start the CrashActivity to display crash details
        Intent intent = new Intent(context, CrashActivity.class);
        intent.putExtra("crashDetails", throwable.getMessage());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        // Terminate the current process to prevent the app from continuing
        System.exit(1);
    }
}
