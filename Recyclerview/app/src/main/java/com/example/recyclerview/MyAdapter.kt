package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//har adapter ka  viewholder hota hai whenver we extend the class of recyclerview.adapter it has three methods inbuilt
class MyAdapter(private val newsArrayList: ArrayList<News>,var context : Activity) :
 RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
//to create new view instance when layout manager fails to find suitable view for each item
 //then jo viewholder m rakha hua itemview h use return karvaenge
 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
// itemview ko dhunda aur nikal liya below step se
  val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
 return MyViewHolder(itemView)
 }
//populate items with data
 override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
  val currentItem=newsArrayList[position]
 //view ko kon hhold kar rha h -> holder as seen as argruement so
 holder.hTitle.text=currentItem.newsHeading
 holder.hImage.setImageResource(currentItem.newsImage)
 }

//how many list items are present in your array
 override fun getItemCount(): Int {
  return newsArrayList.size

 }

 //it hold the views so views are not created everytime ,so memory can be saved
 class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
  val hTitle=itemView.findViewById<TextView>(R.id.headingTitle)
  val hImage=itemView.findViewById<ImageView>(R.id.headingImage)

 }

}
