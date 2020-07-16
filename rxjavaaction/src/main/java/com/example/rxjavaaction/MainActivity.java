package com.example.rxjavaaction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // // Create Observable
        // Observable<Integer> observable = Observable.range(10, 4);
        // Observable<Long> observable = Observable.interval(500, TimeUnit.MICROSECONDS);
        Observable<String> observable = Observable.from(new String[]{"one", "two", "three"});

        // Observer<Long> observer = getObserver();
        // Observer<Integer> observer = getObserver();
        Observer<String> observer = getObserver();

        // Subscribe
        observable.subscribe(observer);
    }

    // Create observable
    private <T> Observer<T> getObserver() {
        return new Observer<T>() {
            @Override
            public void onNext(T s) {
                Log.d(LOG_TAG, "onNext: " + s);
            }

            @Override
            public void onCompleted() {
                Log.d(LOG_TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(LOG_TAG, "onError: " + e);
            }
        };
    }
}
