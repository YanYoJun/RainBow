package com.plbear.yyj.rainbow.Utils

import android.widget.EditText
import com.google.gson.Gson

/**
 * Created by yanyongjun on 2018/1/15.
 */
class Utils {
    companion object {
        var gson = Gson()
        val IS_DEBUG = true

        fun setEditTextEnabled(editText: EditText, enable: Boolean) {
            if (enable) {
                editText.isFocusableInTouchMode = true
                editText.isFocusable = true
                editText.requestFocus()
            } else {
                editText.isFocusable = false
                editText.isFocusableInTouchMode = false
            }
        }
    }
}