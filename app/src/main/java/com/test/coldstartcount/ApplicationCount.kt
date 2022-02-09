package com.test.coldstartcount

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast

class ApplicationCount : Application() {

    private val coun_str = "count"

    override fun onCreate() {
        super.onCreate()
        val pref = applicationContext.getSharedPreferences("count_pref", Context.MODE_PRIVATE)
        val count = pref.getInt(coun_str,0)
        if (count == 2)
            Toast.makeText(this,"Cold start 3!", Toast.LENGTH_LONG).show()
        val edit = pref.edit()
        edit.putInt(coun_str, count+1).apply()
    }
}