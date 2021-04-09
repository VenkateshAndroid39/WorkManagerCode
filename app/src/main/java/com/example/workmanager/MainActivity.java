package com.example.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button btnOneTime,btnPeriodic,btnChain;
    Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOneTime = findViewById(R.id.btnOneTime);
        btnPeriodic = findViewById(R.id.btnPeriodic);
        btnChain = findViewById(R.id.btnChain);



        // one time request
        btnOneTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class).setConstraints(constraints).build();

                WorkManager.getInstance().enqueue(oneTimeWorkRequest);
            }
        });



        // chain request
        btnOneTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class).setConstraints(constraints).build();

                OneTimeWorkRequest oneTimeWorkRequest2 = new OneTimeWorkRequest.Builder(MyWorker2.class).setConstraints(constraints).build();

                WorkManager.getInstance().beginWith(oneTimeWorkRequest).then(oneTimeWorkRequest2).enqueue();
            }
        });




        // periodic request
        btnOneTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWorker.class,2, TimeUnit.SECONDS).setConstraints(constraints).build();
                WorkManager.getInstance().enqueue(periodicWorkRequest);
            }
        });


    }

}