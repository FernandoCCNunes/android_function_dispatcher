package com.nando.function_dispatcher_example

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.nando.function_dispatcher.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : Activity(), Serializable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}