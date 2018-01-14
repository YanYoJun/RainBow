package com.plbear.yyj.rainbow.model.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.plbear.yyj.rainbow.R

/**
 * Created by yanyongjun on 2018/1/13.
 */
class PopWindowAdapter(context: Context, list: ArrayList<String>) : BaseAdapter() {
    var mContext = context
    var mList = list
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v = convertView
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_main_pop_window, null)
        }
        var labMsg = v?.findViewById<TextView>(R.id.lab_msg)
        labMsg?.setText(mList[position])
        return v!!
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return mList.size
    }
}