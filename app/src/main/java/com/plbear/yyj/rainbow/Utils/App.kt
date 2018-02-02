package com.plbear.yyj.rainbow.Utils

import android.app.Application
import android.content.Context

/**
 * Created by yanyongjun on 2018/1/28.
 */
open class App : Application() {
    companion object {
        lateinit var mInstance: App
        fun getAppContext(): Context {
            return mInstance.applicationContext
        }
    }

    override fun onCreate() {
        mInstance = this
        super.onCreate()
    }
}