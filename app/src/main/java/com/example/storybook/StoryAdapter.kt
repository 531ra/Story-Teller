package com.example.storybook

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.contracts.contract

class StoryAdapter(private val dataset:ArrayList<Story>):RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

private var onClickListener:OnClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryAdapter.ViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
           return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryAdapter.ViewHolder, position: Int) {
        holder.tvTitle.setText(dataset[position].title)
        holder.image.setImageResource(dataset[position].image)
        holder.itemView.setOnClickListener{
            if(onClickListener!=null){
                onClickListener!!.onClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
      return dataset.size
    }
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvTitle:TextView=view.findViewById(R.id.tvItemListTitle)
        val image:ImageView=view.findViewById(R.id.itemListImage)

    }

    fun setOnClickListener( onClickListener:OnClickListener){
        this.onClickListener= onClickListener
    }
    interface OnClickListener{
        fun onClick(position:Int)
    }
}