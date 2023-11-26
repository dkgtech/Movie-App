package com.dkgtech.movie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.movie.databinding.GetWhatsStreamingRowBinding
import com.dkgtech.movie.model.Edge
import com.squareup.picasso.Picasso

class RecyclerWhatStreaming(val context: Context, val arrData: ArrayList<Edge>) :
    RecyclerView.Adapter<RecyclerWhatStreaming.ViewHolder>() {
    class ViewHolder(val binding: GetWhatsStreamingRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GetWhatsStreamingRowBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arrData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val data = arrData[position]
            Picasso.get().load(data.title.primaryImage.imageUrl).into(imgThumbnail)
            txtTitle.text = data.title.titleText.text
        }
    }
}