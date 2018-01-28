package com.plbear.yyj.rainbow.storage

import android.content.*
import android.database.Cursor
import android.database.sqlite.SQLiteBlobTooBigException
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri
import android.os.Build.ID
import com.plbear.yyj.rainbow.Utils.App

/**
 * Created by yanyongjun on 2018/1/28.
 */
class DBProvider : ContentProvider() {
    private lateinit var mResolver: ContentResolver
    private lateinit var mDBHelper: DBHelper

    companion object {
        val PROVIDER_ITEMS = 1

        var uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
        var projectMap = HashMap<String, String>()

        init {
            uriMatcher.addURI(Contant.PROVIDER_AUTHORITY, "items", PROVIDER_ITEMS)

            projectMap.put("_id", "_id")
            projectMap.put("title", "title")
            projectMap.put("status", "status")
            projectMap.put("time", "time")
            projectMap.put("data_bean", "data_bean")
        }
    }

    override fun insert(uri: Uri?, values: ContentValues): Uri {
        var db = mDBHelper.writableDatabase
        var id = -1L
        when (uriMatcher.match(uri)) {
            PROVIDER_ITEMS -> {
                id = db.insert(DBHelper.TABLE, "_id", values)
            }
        }
        var newUri = ContentUris.withAppendedId(uri, id)
        mResolver.notifyChange(newUri, null)
        return newUri
    }

    override fun query(uri: Uri?, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor {
        var db = mDBHelper.readableDatabase
        var sqlBuilder = SQLiteQueryBuilder()
        var count = 1
        when (uriMatcher.match(uri)) {
            PROVIDER_ITEMS -> {
                sqlBuilder.tables = DBHelper.TABLE
                sqlBuilder.setProjectionMap(projectMap)
            }
        }
        var cursor = sqlBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder)
        cursor.setNotificationUri(mResolver, uri)
        return cursor
    }

    override fun onCreate(): Boolean {
        mResolver = App.getAppContext().contentResolver
        mDBHelper = DBHelper(App.getAppContext())
        return false
    }

    override fun update(uri: Uri?, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(uri: Uri?, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getType(uri: Uri?): String? {
        return null
    }
}