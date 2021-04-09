package com.example.workmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {


    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
    //    Log.e("Result","Welcome it s working machii a");
   //     Log.d("status****","working");
        Log.d("status","Running**");
      //  mHandler.sendEmptyMessageDelayed(5, 2000);
        return Result.success();
    }

//    private Handler mHandler = new Handler()
//    {
//        @Override
//        public void handleMessage( final Message msg )
//        {
//            switch( msg.what )
//            {
//                case 5:
//                    Log.d("status","Running**");
//                    mHandler.sendEmptyMessageDelayed(5, 3000);
//                    break;
//            }
//        }
//    };
}
