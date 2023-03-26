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

 private lateinit var myListener: onItemClickListener

 //lets create interface
 //ie agar koi bhi class iss interface ko kregi implement toh usse implement karvan pdega all methods inside it which are free or value to be assigned
 interface onItemClickListener{
//toh jo item click karne par hona chahiye hum vhi kam karvaenge isme
  fun onItemClicking(position: Int)
 }

 fun setOnItemClickListener(
  listener: onItemClickListener
 ){
  //now inititalise myListener now
  myListener=listener

 }




//to create new view instance when layout manager fails to find suitable view for each item
 //then jo viewholder m rakha hua itemview h use return karvaenge
 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
// itemview ko dhunda aur nikal liya below step se
  val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
 return MyViewHolder(itemView,myListener)
 //very cleverly humne late init var myListener yahan use karliya as MyviewHolder needs two parameters
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
 class MyViewHolder(itemView : View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView) {
  val hTitle=itemView.findViewById<TextView>(R.id.headingTitle)
  val hImage=itemView.findViewById<ImageView>(R.id.headingImage)

  //now in it it hold the views so in itemview p hum setonclicklistener interface lagaenge
  init {
      itemView.setOnClickListener{
       listener.onItemClicking(adapterPosition)
       //getadapterposition by default funciton btata hain positon it is builitin

      }
  }

 }

}
