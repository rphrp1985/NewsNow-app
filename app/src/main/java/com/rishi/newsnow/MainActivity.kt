package com.rishi.newsnow

import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_news.*
import androidx.browser.customtabs.CustomTabColorSchemeParams





class MainActivity : AppCompatActivity(), Newsitemclicked {

    private lateinit var mAdapter:NewsListAdapter
//    textView2.text

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
        Toast.makeText(this,"Developed by Prianshu Prasad",Toast.LENGTH_LONG).show()
        recyclerView.layoutManager= LinearLayoutManager(this)
//        val arr= fetchdata()
//            val arr// ArrayList<String>()

//        arr.add("rp")
//
//        for( i in 0 until 100){
//             arr.add("item $i")
//
//        }

    fetchdata()
      mAdapter=  NewsListAdapter(this)
           recyclerView.adapter= mAdapter





    }




   private fun fetchdata() {
        Log.d("my app", "hi")
//        val queue= Volley.newRequestQueue(this)
        val url="https://saurav.tech/NewsAPI/everything/bbc-news.json"

        val jore = JsonObjectRequest(Request.Method.GET, url,null,
            { response ->

                val jsonarray= response.getJSONArray("articles")
                val NewsArray= ArrayList<News>()
                Log.d("my log", "${jsonarray.length()}");
                 for(i in 0 until jsonarray.length())
                 {
                     val tempjsonobjct= jsonarray.getJSONObject(i)
                     val tempnews= News(
                         tempjsonobjct.getString("title" ),
                         tempjsonobjct.getString("description" ),
                         tempjsonobjct.getString("url" ),
                         tempjsonobjct.getString("urlToImage" )
//                         "rp", "rp","rp","rp"


                     )

                     NewsArray.add(tempnews)
                 }


                 mAdapter.updatenews(NewsArray)
//                 return NewsArray

            },
            {
                Toast.makeText(this,"Something went wrong!",Toast.LENGTH_LONG).show()
            })
           MySingleton.getInstance(this).addToRequestQueue(jore)
// Add the request to the RequestQueue.
//        queue.add(jore)


    }

    override fun onitemclicked(item: News) {
        Toast.makeText( this,"Opening News", Toast.LENGTH_LONG).show()
        val url:String = item.url
       val builder= CustomTabsIntent.Builder();
        val colorInt: Int = Color.parseColor("#0000FF") //red

        val defaultColors = CustomTabColorSchemeParams.Builder()
            .setToolbarColor(colorInt)
            .build()
        builder.setDefaultColorSchemeParams(defaultColors)


        val customTabsIntent = builder.build();




        customTabsIntent.launchUrl(this, Uri.parse(url));




    }


}

