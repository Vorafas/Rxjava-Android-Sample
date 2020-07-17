package com.example.rxjavafilter;

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

        Observable<String> observable = Observable
                .from(new String[]{"55", "10", "5", "90", "645", "77"})
                .filter(filterFiveOnly);

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

    Func1<String, Boolean> filterFiveOnly = new Func1<String, Boolean>() {
        @Override
        public Boolean call(String s) {
            return s.contains("5");
        }
    };
}
