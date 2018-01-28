package com.plbear.yyj.rainbow.storage

import android.net.Uri

/**
 * Created by yanyongjun on 2018/1/28.
 */
class Contant {
    companion object {
        val PROVIDER_AUTHORITY = "com.plbear.yyj.rainbow"
        val CONTENT_URI_ITEMS = Uri.parse("contents://" + PROVIDER_AUTHORITY + "/items")

        val COLUMN_ID = "_id"
        val COLUMN_TITLE = "title"
        val COLUMN_STATUS = "status"
        val COLUMN_TIME = "time"
        val COLUMN_DATA_BEAN = "data_bean"
    }
}

//projectMap.put("_id", "_id")
//projectMap.put("title", "title")
//projectMap.put("status", "status")
//projectMap.put("time", "time")
//projectMap.put("data_bean", "data_bean")