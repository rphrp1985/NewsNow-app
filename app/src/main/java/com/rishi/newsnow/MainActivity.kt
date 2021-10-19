package com.rishi.newsnow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
        recyclerView.layoutManager= LinearLayoutManager(this)
        val arr= fetchdata()
//            ArrayList<String>()

//        arr.add("rp")

        val adapter=  NewsListAdapter(arr)
           recyclerView.adapter= adapter





    }


    fun fetchdata(): ArrayList<String> {
          val arr= ArrayList<String>()
         var i=0
        for( i in 0 until 100){

             arr.add("Iteam $i")
        }
     return arr

    }


}