package com.example.rxjavaskip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<Integer> observable = Observable
                .from(new Integer[]{5, 6, 7, 8, 9})
                .skip(2);

        observable.subscribe(observer);
    }

    Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onNext(Integer s) {
            Log.d(TAG, "onNext: " + s);
        }

        @Override
        public void onError(Throwable e) {
            Log.d(TAG, "onError: " + e);
        }

        @Override
        public void onCompleted() {
            Log.d(TAG, "onCompleted");
        }
    };
}
