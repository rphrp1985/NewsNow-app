package com.rishi.newsnow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter( private val listener: Newsitemclicked): RecyclerView.Adapter<NewsViewHolder>()
{
    private val item: ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

         val view= LayoutInflater.from(parent.context).inflate(R.layout.`item_news`,parent,false)

  val viewHolder=NewsViewHolder(view)


        view.setOnClickListener{

            listener.onitemclicked(item[viewHolder.adapterPosition ])

        }

        return viewHolder



    }


    override fun getItemCount(): Int {
        return item.size
    }



    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

       val curritem= item[position]

        holder.titleview.text   = curritem.title
        holder.description.text= curritem.Description
      Glide.with(holder.imageView.context).load(curritem.urltoimage).into(holder.imageView)


    }

    fun updatenews(Newsarray:ArrayList<News>){

        item.clear()
        item.addAll(Newsarray)

        notifyDataSetChanged()

    }




}




class NewsViewHolder(itemViews: View): RecyclerView.ViewHolder(itemViews){

    var titleview: TextView= itemViews.findViewById(R.id.newstitle)
    var imageView: ImageView = itemViews.findViewById(R.id.newsimage)
    var description: TextView = itemViews.findViewById(R.id.description)
}

interface Newsitemclicked{
    fun onitemclicked(item: News)
}