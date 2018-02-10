package com.plbear.yyj.rainbow.model.main.adapter

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import com.plbear.yyj.rainbow.data.DataBean
import com.plbear.yyj.rainbow.R
import com.plbear.yyj.rainbow.Utils.ToastUtils
import com.plbear.yyj.rainbow.Utils.Utils
import java.util.*

/**
 * Created by yanyongjun on 2018/1/27.
 */
class AddAdapter(context: Context, data: ArrayList<DataBean>) : BaseAdapter() {
    companion object {
        val TAG = "AddAdapter"
    }

    private var mContext = context
    private var mDatas = data
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var v = convertView
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_add, null)
        }
        var edit_name = v?.findViewById<EditText>(R.id.edit_name)
        var edit_time = v?.findViewById<EditText>(R.id.edit_time)
        var edit_des = v?.findViewById<EditText>(R.id.edit_des)
        var btn_add_new = v?.findViewById<Button>(R.id.btn_add_new)
        Log.e(TAG, "yanlog postion:$position size:${mDatas.size}")
        if (position >= mDatas.size) {
            //this part is the last item
            edit_name?.setText("")
            edit_time?.setText("")
            edit_des?.setText("")
            Utils.setEditTextEnabled(edit_des!!, true)
            Utils.setEditTextEnabled(edit_time!!, true)
            Utils.setEditTextEnabled(edit_name!!, true)
            btn_add_new?.visibility = View.VISIBLE
            btn_add_new?.setOnClickListener {
                var title = edit_name?.text.toString()
                var des = edit_des?.text.toString()
                var time = edit_time?.text.toString()
                if (checkData(title, des, time)) {
                    var bean = DataBean(title, time.toLong(), des)
                    Log.e(TAG, "add $bean")
                    mDatas.add(bean)
                    this@AddAdapter.notifyDataSetChanged()
                }
            }
        } else {
            Utils.setEditTextEnabled(edit_name!!, false)
            Utils.setEditTextEnabled(edit_des!!, false)
            Utils.setEditTextEnabled(edit_time!!, false)
            btn_add_new?.visibility = View.INVISIBLE
            var data = mDatas[position]
            edit_name?.setText(data.title)
            edit_time?.setText("" + data.time)
            edit_des?.setText(data.content)
            Log.e(TAG, "$position : $data")
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

    fun checkData(title: String, des: String, time: String): Boolean {
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(des) || TextUtils.isEmpty(time)) {
            ToastUtils.show("有字段为空")
            return false
        }
        try {
            time.toLong()
        } catch (e: Exception) {
            ToastUtils.show("请输入数字")
            return false
        }
        return true
    }
}