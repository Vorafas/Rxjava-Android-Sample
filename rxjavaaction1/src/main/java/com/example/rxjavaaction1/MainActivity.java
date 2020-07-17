package com.example.rxjavaaction1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create observable
        Observable<String> observable = Observable.from(new String[]{"one", "two", "three"});

        // Subscribe
        observable.subscribe(onNext, onError, onCompleted);
    }

    // Create action
    Action1<String> onNext = new Action1<String>() {
        @Override
        public void call(String s) {
            Log.d(TAG, "onNext: " + s);
        }
    };

    // Create action
    Action1<Throwable> onError = new Action1<Throwable>() {
        @Override
        public void call(Throwable e) {
            Log.d(TAG, "onError: " + e);
        }
    };

    // Create action
    Action0 onCompleted = new Action0() {
        @Override
        public void call() {
            Log.d(TAG, "onCompleted");
        }
    };
}
