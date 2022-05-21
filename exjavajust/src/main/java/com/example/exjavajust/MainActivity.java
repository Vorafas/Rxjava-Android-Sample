package com.example.exjavajust;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import rx.Observable;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> observable = Observable.just("one", "two", "three");

        observable.subscribe(this::onNext, this::onError, this::onCompleted);
    }

    private void onNext(String s) {
        Log.d(TAG, "onNext: " + s);
    }

    private void onError(Throwable e) {
        Log.d(TAG, "onError: " + e);
    }

    private void onCompleted() {
        Log.d(TAG, "onCompleted");
    }
}
