package com.tahirahearle.ucc

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberAdapter(private val members: List<Member>) :
    RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {

    class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoImageView: ImageView = itemView.findViewById(R.id.member_photo)
        val nameTextView: TextView = itemView.findViewById(R.id.member_name)
        val jobpositionTextView : TextView= itemView.findViewById(R.id.member_position)
        val phoneNumberTextView: TextView = itemView.findViewById(R.id.member_phone_number)
        val emailTextView: TextView = itemView.findViewById(R.id.member_email)
        val callButton: Button = itemView.findViewById(R.id.call_button)
        val emailButton: Button = itemView.findViewById(R.id.email_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.member_item, parent, false)
        return MemberViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val currentMember = members[position]
        holder.photoImageView.setImageResource(currentMember.photo)
        holder.nameTextView.text = currentMember.name
        holder.phoneNumberTextView.text = currentMember.phoneNumber
        holder.emailTextView.text = currentMember.email
        holder.jobpositionTextView.text=currentMember.jobposition
        holder.callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${currentMember.phoneNumber}"))
            holder.itemView.context.startActivity(intent)
        }
        holder.emailButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${currentMember.email}"))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = members.size
}
