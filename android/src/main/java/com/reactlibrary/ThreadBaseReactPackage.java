package com.reactlibrary;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.TimingModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.modules.debug.DevSettingsModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;

public class ThreadBaseReactPackage implements ReactPackage {

    private final ReactInstanceManager reactInstanceManager;

    public ThreadBaseReactPackage(ReactInstanceManager reactInstanceManager) {
        this.reactInstanceManager = reactInstanceManager;
    }

    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext catalystApplicationContext) {
        return Arrays.<NativeModule>asList(
                // Core list
                new AndroidInfoModule(catalystApplicationContext),
                new ExceptionsManagerModule(reactInstanceManager.getDevSupportManager()),
                new AppStateModule(catalystApplicationContext),
                new TimingModule(catalystApplicationContext, reactInstanceManager.getDevSupportManager()),
//                new UIManagerModule(catalystApplicationContext, reactInstanceManager.getOrCreateViewManagers(catalystApplicationContext), -1),
                new DeviceInfoModule(catalystApplicationContext),
//                new SourceCodeModule(catalystApplicationContext),
//                new JSCHeapCapture(catalystApplicationContext),
                new UIManagerModule(catalystApplicationContext, createViewManagers(catalystApplicationContext), 0),
                new SourceCodeModule(catalystApplicationContext), new JSCHeapCapture(catalystApplicationContext),

                // Main list
//                new AsyncStorageModule(catalystApplicationContext),
                new IntentModule(catalystApplicationContext),
                new NetworkingModule(catalystApplicationContext),
                new VibrationModule(catalystApplicationContext),
                new WebSocketModule(catalystApplicationContext),
                new ThreadSelfModule(catalystApplicationContext),
                new DevSettingsModule(catalystApplicationContext, reactInstanceManager.getDevSupportManager())
        );
    };

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        return new ArrayList<>(0);
    }
}
