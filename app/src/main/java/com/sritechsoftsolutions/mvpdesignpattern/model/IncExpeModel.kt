package com.sritechsoftsolutions.mvpdesignpattern.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.widget.SimpleCursorAdapter
import com.sritechsoftsolutions.mvpdesignpattern.bean.IncExpBean
import com.sritechsoftsolutions.mvpdesignpattern.presenter.IncExpPresenterApi
import com.sritechsoftsolutions.mvpdesignpattern.view.IncExpeViewApi
import com.sritechsoftsolutions.mvpdesignpattern.view.MainActivity
import java.util.*

class IncExpeModel(var api:IncExpeViewApi):IncExpPresenterApi {

    var dBase:SQLiteDatabase?=null
    var mActivity:MainActivity?=null
    init {
        mActivity=api as MainActivity
        dBase=mActivity!!.openOrCreateDatabase("money",Context.MODE_PRIVATE,null)
        dBase?.execSQL("create table if not exists usermoney(_id integer primary key autoincrement,date varchar(20),money integer(20),description varchar(50),type varchar(20) ) ")


    }

    override fun save(bean: IncExpBean) {
        var cv=ContentValues()
        cv.put("date",bean.date)
        cv.put("money",bean.money)
        cv.put("description",bean.desc)
        cv.put("type",bean.type)

        var status=dBase?.insert("usermoney",null,cv)
        if (status!=-1L)
        {
            api.saveResponse("row inserted successfully")

        }
        else
        {
            api.saveResponse("row insertion failed")

        }
    }

    override fun read() {
        var c:Cursor?=dBase?.query("usermoney",null,null,null,null,null,null)
        api.readResponse(c!!)
    }
}