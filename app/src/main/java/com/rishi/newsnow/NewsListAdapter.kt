package com.rishi.newsnow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val item: ArrayList<String>): RecyclerView.Adapter<NewsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

         val view= LayoutInflater.from(parent.context).inflate(R.layout.`item_news`,parent,false)
        return NewsViewHolder(view)

        view.setOnClickListener{

        }


    }


    override fun getItemCount(): Int {
        return item.size
    }



    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

       val curritem= item[position]

        holder.titleview.text   = curritem

    }

}




class NewsViewHolder(itemViews: View): RecyclerView.ViewHolder(itemViews){

    var titleview: TextView= itemViews.findViewById(R.id.textView)
}