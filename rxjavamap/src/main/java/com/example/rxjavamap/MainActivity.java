package com.example.rxjavamap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<Integer> observable = Observable
                .from(new String[]{"1", "2", "3", "4", "5"})
                .map(stringToInteger);

        observable.subscribe(observer);
    }

    private Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onNext(Integer s) {
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

    private Func1<String, Integer> stringToInteger = new Func1<String, Integer>() {
        @Override
        public Integer call(String s) {
            return Integer.parseInt(s);
        }
    };
}
