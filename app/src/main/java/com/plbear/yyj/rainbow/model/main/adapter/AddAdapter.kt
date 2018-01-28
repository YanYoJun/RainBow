package com.plbear.yyj.rainbow.model.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.plbear.yyj.rainbow.data.DataBean
import com.plbear.yyj.rainbow.R

/**
 * Created by yanyongjun on 2018/1/27.
 */
class AddAdapter(context: Context, data: ArrayList<DataBean>) : BaseAdapter() {
    private var mContext = context
    private var mDatas = data
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var v = convertView
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_add, null)
        }
        return v
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return mDatas.size + 1
    }
}