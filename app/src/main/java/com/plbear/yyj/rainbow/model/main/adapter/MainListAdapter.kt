package com.plbear.yyj.rainbow.model.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.plbear.yyj.rainbow.Data.TotalDataBean
import com.plbear.yyj.rainbow.R

/**
 * Created by yanyongjun on 2018/1/14.
 */
class MainListAdapter(context: Context, datas: ArrayList<TotalDataBean>) : BaseAdapter() {
    var mContext = context
    var mDatas = datas

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var v = convertView
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_main, null)
        }
        var lab_title = v?.findViewById<TextView>(R.id.lab_title)
        var lab_status = v?.findViewById<TextView>(R.id.lab_status)
        var lab_time = v?.findViewById<TextView>(R.id.lab_time)
        var btn_delete = v?.findViewById<Button>(R.id.btn_delete)
        var btn_edit = v?.findViewById<Button>(R.id.btn_edit)
        btn_delete?.setOnClickListener {
            //TODO
        }
        btn_edit?.setOnClickListener {
            //TODO
        }
        return v
    }

    override fun getItem(position: Int): Any {
        return ""
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return mDatas.size
    }
}