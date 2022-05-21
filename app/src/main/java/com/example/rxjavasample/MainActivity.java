package com.example.rxjavasample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> observable = Observable.from(new String[]{"one", "two", "three"});

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onNext(String s) {
                Log.d(LOG_TAG, "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(LOG_TAG, "onError: " + e);
            }

            @Override
            public void onCompleted() {
                Log.d(LOG_TAG, "onCompleted");
            }
        };

        observable.subscribe(observer);
    }
}