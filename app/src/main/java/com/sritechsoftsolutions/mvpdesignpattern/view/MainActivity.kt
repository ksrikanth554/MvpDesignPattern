package com.sritechsoftsolutions.mvpdesignpattern.view

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import com.sritechsoftsolutions.mvpdesignpattern.R
import com.sritechsoftsolutions.mvpdesignpattern.bean.IncExpBean
import com.sritechsoftsolutions.mvpdesignpattern.model.IncExpeModel
import com.sritechsoftsolutions.mvpdesignpattern.presenter.IncExpPresenterApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IncExpeViewApi {
    override fun saveResponse(msg: String) {

        Toast.makeText(this@MainActivity,msg,Toast.LENGTH_LONG).show()

    }

    override fun readResponse(c: Cursor) {
        var cAdapter=SimpleCursorAdapter(this@MainActivity,R.layout.displayview,c, arrayOf("_id","date","money","description","type"),
            intArrayOf(R.id.txtid,R.id.txtdate,R.id.txtmoney,R.id.txtdescrption,R.id.txttype),0)
        lview.adapter=cAdapter
        var isum=0
        var esum=0
        while (c.moveToNext())
        {
            if (c.getString(4).equals("income",true))
            {
                isum=isum+c.getInt(2)
            }
            else
            {
                esum=esum+c.getInt(2)
            }
            txtincome.setText("Income: $isum")
            txtexpense.setText("Expnese: $esum")
        }



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var model:IncExpPresenterApi=IncExpeModel(this@MainActivity)

        btnsave.setOnClickListener {
            var bean=IncExpBean(edtdate.text.toString(),
                edtmoney.text.toString().toInt(),
                edtdesc.text.toString(),spntype.selectedItem.toString())
            model.save(bean)
            edtdate.setText("")
            edtmoney.setText("")
            edtdesc.setText("")
            spntype.setSelection(0)

        }
        btnread.setOnClickListener {
            model.read()

        }
    }
}
