package com.plbear.yyj.rainbow.storage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build

/**
 * Created by yanyongjun on 2018/1/28.
 */
class DBHelper(context:Context) : SQLiteOpenHelper(context,"rainrow.db",null,1) {
    companion object {
        val TABLE = "rainrow"
    }
    val SQL_CREATE_TABLE="create table rainrow (_id integer primary key autoincrement,title text,status integer,time text,data_bean text)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}