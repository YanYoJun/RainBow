package com.plbear.yyj.rainbow.storage

import android.content.ContentValues
import com.plbear.yyj.rainbow.Utils.App
import com.plbear.yyj.rainbow.Utils.Utils
import com.plbear.yyj.rainbow.data.TotalDataBean

/**
 * Created by yanyongjun on 2018/1/28.
 */
class DataManager {
    var mResolver = App.getAppContext().contentResolver

    companion object {
        var mInstance = DataManager()
        fun getInstance(): DataManager {
            return mInstance
        }
    }

    fun insert(bean: TotalDataBean) {
        var values = ContentValues()
        values.put(Contant.COLUMN_TITLE, bean.title)
        values.put(Contant.COLUMN_STATUS, bean.status)
        values.put(Contant.COLUMN_TIME, bean.time)
        values.put(Contant.COLUMN_DATA_BEAN, Utils.gson.toJson(bean.dataList))
        mResolver.insert(Contant.CONTENT_URI_ITEMS, values)
    }
}