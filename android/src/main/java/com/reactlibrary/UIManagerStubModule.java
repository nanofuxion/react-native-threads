package com.reactlibrary;

import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import androidx.annotation.NonNull;

public class UIManagerStubModule extends ReactContextBaseJavaModule implements OnBatchCompleteListener {

    public UIManagerStubModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "UIManager";
    }

    @Override
    public void onBatchComplete() {

    }
}
