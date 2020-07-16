package com.example.rxjavabuffer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create observable
        Observable<List<Integer>> observable = Observable
                .from(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8})
                .buffer(3);

        observable.subscribe(observer);
    }

    // Create observer
    private Observer<List<Integer>> observer = new Observer<List<Integer>>() {
        @Override
        public void onCompleted() {
            Log.d(TAG, "onCompleted");
        }

        @Override
        public void onNext(List<Integer> s) {
            Log.d(TAG, "onNext: " + s);
        }

        @Override
        public void onError(Throwable e) {
            Log.d(TAG, "onError: " + e);
        }
    };
}
