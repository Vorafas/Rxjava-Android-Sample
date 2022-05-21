package com.example.rxjavaten;

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

        Observable<Boolean> observable = Observable
                .from(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8})
                .all(lessThenTen);

        observable.subscribe(observer);
    }

    protected Observer<Boolean> observer = new Observer<Boolean>() {
        @Override
        public void onNext(Boolean s) {
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

    Func1<Integer, Boolean> lessThenTen = new Func1<Integer, Boolean>() {
        @Override
        public Boolean call(Integer i) {
            return i < 10;
        }
    };
}
