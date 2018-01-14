package com.plbear.yyj.rainbow.activity

import android.content.Intent
import android.os.AsyncTask
import com.plbear.yyj.rainbow.R
import com.plbear.yyj.rainbow.Utils.AppManager
import com.plbear.yyj.rainbow.model.main.MainActivity

/**
 * Created by yanyongjun on 2018/1/1.
 */
class SplashActivity : BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_splash
    }

    override fun afterCreated() {
        var task = object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void?): Void? {
                Thread.sleep(500)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                var intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                AppManager.getAppManager().finishCurActivity(this@SplashActivity)
            }
        }
        task.execute()
    }
}