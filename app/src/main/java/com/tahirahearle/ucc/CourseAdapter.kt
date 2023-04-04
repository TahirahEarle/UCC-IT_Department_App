package com.tahirahearle.ucc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CourseAdapter(private val courseList: ArrayList<Course>):
    RecyclerView.Adapter<CourseAdapter.MyViewHolder>() {

     class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
         val code: TextView = itemView.findViewById(R.id.tvCode)
         val name: TextView = itemView.findViewById(R.id.tvName)
         val credits: TextView = itemView.findViewById(R.id.tvCredits)
         val preRequisite: TextView = itemView.findViewById(R.id.tvPreReq)
         val description: TextView = itemView.findViewById(R.id.tvDescription)
         val textbookImage: ImageView = itemView.findViewById(R.id.CourseImg)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.code.text = courseList[position].Code
        holder.name.text = courseList[position].Name
        holder.credits.text = courseList[position].Credits
        holder.preRequisite.text = courseList[position].PreRequisite
        holder.description.text = courseList[position].Description


        Glide.with(holder.itemView.context)
            .load(courseList[position].Textbook)
            .into(holder.textbookImage)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}