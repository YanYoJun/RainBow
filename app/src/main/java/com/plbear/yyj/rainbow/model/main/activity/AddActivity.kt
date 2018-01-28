package com.plbear.yyj.rainbow.model.main.activity

import android.view.View
import com.plbear.yyj.rainbow.data.DataBean
import com.plbear.yyj.rainbow.R
import com.plbear.yyj.rainbow.Utils.ToastUtils
import com.plbear.yyj.rainbow.activity.BaseActivity
import com.plbear.yyj.rainbow.model.main.adapter.AddAdapter
import kotlinx.android.synthetic.main.activity_add.*

/**
 * Created by yanyongjun on 2018/1/27.
 */
class AddActivity : BaseActivity() {
    private var mDatas = ArrayList<DataBean>()
    private lateinit var mAdapter: AddAdapter
    override fun getLayout(): Int {
        return R.layout.activity_add
    }

    override fun afterCreated() {
        mAdapter = AddAdapter(this, mDatas)
        listview.adapter = mAdapter
    }

    fun onClick_back(v: View) {
        finish()
    }

    fun onClick_save(v: View) {
        ToastUtils.show("save")
    }
}