package com.sritechsoftsolutions.mvpdesignpattern.view

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sritechsoftsolutions.mvpdesignpattern.R

class MainActivity : AppCompatActivity(),IncExpeViewApi {
    override fun saveResponse(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readResponse(c: Cursor) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
