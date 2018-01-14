package com.plbear.yyj.rainbow.Utils

import android.app.Activity
import java.util.*

/**
 * Created by yanyongjun on 2018/1/1.
 */
open class AppManager private constructor(){
    companion object {
        private var mActivitys = Stack<Activity>()
        private var mInstance = AppManager()
        fun getAppManager():AppManager{
            return mInstance
        }
    }

    fun addToActivitys(activity:Activity){
        mActivitys.add(activity)
    }

    fun removeActivity(activity:Activity){
        mActivitys.remove(activity)
    }

    fun finishCurActivity(activity: Activity){
        mActivitys.remove(activity)
        activity.finish()
    }

    fun finishAllActivity(){
        while(!mActivitys.isEmpty()){
            var activity = mActivitys.pop()
            activity.finish()
        }
    }
}