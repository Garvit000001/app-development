package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productArrayList: List<Product>) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=productArrayList[position]
        //kis item p h pata karne ke bad hum jo myview(holder) h which is holding the ui/ux i.e. view jo init kiya tha usme
        //text data populate karenge in this method
        holder.title.text=currentItem.title

        //imageview,how to show image in imageview if the image is in the form of Url
        //so we can do this using third party library ie picasso
        //Picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);


    }
    override fun getItemCount(): Int {
        return productArrayList.size
    }
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        val title:TextView
        val image:ShapeableImageView
        //now i will initialise
        init{
            title=itemView.findViewById(R.id.productTitle)
            image=itemView.findViewById(R.id.productImage)
        }

    }
}