package com.btabdul.crash;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.btabdul.crash.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // set content view to binding's root
        setContentView(binding.getRoot());

        // Set the custom exception handler
        Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler(MainActivity.this));

        // Button to cause a crash for testing,
        Button crashButton = binding.crashButton;

        crashButton.setOnClickListener(
                a -> {
                    // Simulate a crash by throwing an exception
                    throw new NullPointerException("Test crash: Null pointer exception");
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
