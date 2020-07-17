package com.example.rxjavatakeuntil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<Integer> observable = Observable
                .from(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})
                .takeUntil(isFive);

        observable.subscribe(observer);
    }

    private Observer<Integer> observer = new Observer<Integer>() {
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

    private Func1<Integer, Boolean> isFive = new Func1<Integer, Boolean>() {
        @Override
        public Boolean call(Integer i) {
            return i == 5;
        }
    };
}
