package com.example.new_hello_world

import androidx.annotation.NonNull
import com.example.myandroidsdk.MySDK // Import the SDK class
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "com.example.myandroidsdk/mysdk"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
            .setMethodCallHandler { call, result ->
                if (call.method == "printAndroidVersion") {
                    // Call the SDK methods
                    val androidVersion = MySDK.getAndroidVersion()
                    MySDK.printAndroidVersion()
                    result.success(androidVersion)
                } else {
                    result.notImplemented()
                }
            }
    }
}
