package com.example.playzone_mobile.android

import PlatformSDK
import android.app.Application
import platform.PlatformConfiguration

class PlayzoneApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun PlayzoneApp.initPlatformSDK() =
    PlatformSDK.init(
        configuration = PlatformConfiguration(androidContext = applicationContext)
    )