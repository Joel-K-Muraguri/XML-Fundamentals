package com.joel.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (
    private val image: List<Images>

) : RecyclerView.Adapter<ImageAdapter.ImagesViewHolder>() {

    class ImagesViewHolder(imageView: View) : RecyclerView.ViewHolder(imageView){
        val ivImageView : ImageView = imageView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item,parent,false)
        return ImagesViewHolder(view)

    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val imageBinder = image[position]

        holder.ivImageView.setImageResource(R.drawable.rhinos_images)
    }

    override fun getItemCount(): Int {
       return image.size
    }
}