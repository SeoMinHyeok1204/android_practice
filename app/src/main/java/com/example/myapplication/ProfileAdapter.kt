package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ProfileAdapter(val profileList:ArrayList<Profiles>) : Adapter<ProfileAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.type.setImageResource(profileList.get(position).type)
        holder.name.text = profileList.get(position).name
        holder.age.text = profileList.get(position).age.toString()
        holder.greet.text = profileList.get(position).greet
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class CustomViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val type : ImageView = itemView.findViewById(R.id.iv_type)
        val name : TextView = itemView.findViewById(R.id.name)
        val age : TextView = itemView.findViewById(R.id.age)
        val greet : TextView = itemView.findViewById(R.id.greet)
    }
}