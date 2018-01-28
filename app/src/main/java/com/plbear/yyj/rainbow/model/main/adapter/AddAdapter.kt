package com.plbear.yyj.rainbow.model.main.adapter

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import com.plbear.yyj.rainbow.data.DataBean
import com.plbear.yyj.rainbow.R
import com.plbear.yyj.rainbow.Utils.TimeUtils
import java.util.*

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
        var edit_name = v?.findViewById<EditText>(R.id.edit_name)
        var edit_time = v?.findViewById<EditText>(R.id.edit_time)
        var edit_des = v?.findViewById<EditText>(R.id.edit_des)
        if (position != mDatas.size) {
            var btn_save = v?.findViewById<Button>(R.id.btn_add_new)
            btn_save?.visibility = View.INVISIBLE
            var bean = DataBean(edit_name?.text.toString(), edit_time?.text.toString().toLong(), edit_des?.text.toString())
            btn_save?.setOnClickListener {
                mDatas.add(bean)
                this@AddAdapter.notifyDataSetChanged()
            }
            mDatas.add(bean)
            notifyDataSetChanged()
        } else {
            var data = mDatas[position]
            edit_name?.setText(data.title)
            edit_time?.setText(TimeUtils.Companion.format_yyyy_MM_dd_HH_mm_ss.format(Date(data.time)))
            edit_des?.setText(data.content)

            edit_name?.addTextChangedListener(object:TextWatcher{
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    data.title = s.toString()
                }
            })

            edit_time?.addTextChangedListener(object:TextWatcher{
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    data.time = TimeUtils.format_yyyy_MM_dd_HH_mm_ss.parse(s.toString()).time
                }
            })

            edit_des?.addTextChangedListener(object:TextWatcher{
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    data.content = s.toString()
                }
            })
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