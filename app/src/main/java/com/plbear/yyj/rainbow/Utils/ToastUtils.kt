package com.plbear.yyj.rainbow.Utils

import android.widget.Toast

/**
 * Created by yanyongjun on 2018/1/28.
 */
class ToastUtils {
    companion object {
        var mToast = Toast.makeText(App.getAppContext(), "", Toast.LENGTH_SHORT);
        fun show(str: String) {
            mToast.setText(str)
            mToast.show()
        }
    }
}