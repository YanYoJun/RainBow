package com.plbear.yyj.rainbow.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.plbear.yyj.rainbow.Utils.AppManager

/**
 * Created by yanyongjun on 2018/1/1.
 */
abstract class BaseActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName
    abstract fun getLayout(): Int
    abstract fun afterCreated()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        AppManager.getAppManager().addToActivitys(this)
        afterCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.getAppManager().removeActivity(this)
    }
}