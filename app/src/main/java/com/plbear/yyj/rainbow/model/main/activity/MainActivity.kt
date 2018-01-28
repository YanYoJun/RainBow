package com.plbear.yyj.rainbow.model.main.activity

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.PopupWindow
import com.plbear.yyj.rainbow.data.DataBean
import com.plbear.yyj.rainbow.data.TotalDataBean
import com.plbear.yyj.rainbow.R
import com.plbear.yyj.rainbow.activity.BaseActivity
import com.plbear.yyj.rainbow.model.main.adapter.MainListAdapter
import com.plbear.yyj.rainbow.model.main.adapter.PopWindowAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    var debug = true
    var mDatas = ArrayList<TotalDataBean>()
    lateinit var mAdapter: MainListAdapter
    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun afterCreated() {
        forDebug()
        mAdapter = MainListAdapter(this, mDatas)
        listview.adapter = mAdapter
    }

    fun forDebug() {
        if (!debug) {
            return
        }
        var list = ArrayList<DataBean>()
        var dataBean = DataBean("俯卧撑", 60 * 1000, "开始做俯卧撑")
        list.add(dataBean)
        dataBean = DataBean("休息", 20 * 1000, "休息20秒")
        list.add(dataBean)
        var bean = TotalDataBean("运动闹钟", 1, 2 * 60 * 1000, list)
        mDatas.add(bean)

        bean = TotalDataBean("土豆炖鸡块", 0, 2 * 60 * 1000, list)
        mDatas.add(bean)
    }

    /**
     * click the button on title
     */
    fun onClick_more(v: View) {
        var window = PopupWindow(this, null)
        var layout = LayoutInflater.from(this).inflate(R.layout.window_main_pop, null)
        window.contentView = layout
        window.width = ViewGroup.LayoutParams.WRAP_CONTENT
        window.height = ViewGroup.LayoutParams.WRAP_CONTENT
        window.setBackgroundDrawable(ColorDrawable(0x000000))
        window.isOutsideTouchable = false
        window.isFocusable = true

        var listview = layout.findViewById<ListView>(R.id.listview_more)
        var datas = ArrayList<String>()
        datas.add("新增秒表")
        datas.add("扫一扫")
        datas.add("分享")
        datas.add("关于")
        var adapter = PopWindowAdapter(this, datas)
        listview.adapter = adapter

        listview.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (id) {
                    0L -> {
                        var i = Intent(this@MainActivity, AddActivity::class.java)
                        startActivity(i)
                    }
                    else -> {
                        //TODO
                    }
                }

                if(window.isShowing){
                    window.dismiss()
                }
            }
        })
        window.showAsDropDown(btn_more)
    }


}
