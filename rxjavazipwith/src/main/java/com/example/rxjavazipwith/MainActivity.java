package com.example.rxjavazipwith;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.functions.Func2;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> observable = Observable
                .from(new Integer[]{1, 2, 3})
                .zipWith(Observable.from(new String[]{"One", "Two", "Three"}), zipIntWithString);

        observable.subscribe(observer);
    }

    Observer<String> observer = new Observer<String>() {
        @Override
        public void onNext(String s) {
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

    Func2<Integer, String, String> zipIntWithString = new Func2<Integer, String, String>() {
        @Override
        public String call(Integer i, String s) {
            return s + ": " + i;
        }
    };
}
