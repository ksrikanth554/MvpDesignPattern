package com.sritechsoftsolutions.mvpdesignpattern.view

import android.database.Cursor

interface IncExpeViewApi {
    fun saveResponse(msg:String)
    fun readResponse(c:Cursor)
}