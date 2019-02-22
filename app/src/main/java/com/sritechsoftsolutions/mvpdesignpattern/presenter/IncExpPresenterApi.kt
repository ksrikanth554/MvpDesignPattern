package com.sritechsoftsolutions.mvpdesignpattern.presenter

import com.sritechsoftsolutions.mvpdesignpattern.bean.IncExpBean

interface IncExpPresenterApi {
    fun save(bean:IncExpBean)
    fun read()
}