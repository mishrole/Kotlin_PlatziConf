package com.mishrole.platziconf.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mishrole.platziconf.databinding.ItemSpeakerBinding
import com.mishrole.platziconf.core.entity.Speaker

class SpeakersAdapter (
    private val speakersData : MutableList<Speaker> = mutableListOf()
) : RecyclerView.Adapter<SpeakersAdapter.ViewHolder>() {

    var onItemClickListener : OnItemClickListener? = null

    inner class ViewHolder (
        private val itemBinding : ItemSpeakerBinding
        ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(speaker : Speaker) {
            itemBinding.tvSpeakerName.text = speaker.name
            itemBinding.tvSpeakerWork.text = speaker.workPlace

            Glide.with(itemBinding.root.context)
                .load(speaker.image)
                .apply(RequestOptions.circleCropTransform())
                .into(itemBinding.ivSpeakerImage)

            itemBinding.root.setOnClickListener {
                onItemClickListener?.onClick(speaker)
            }
        }
    }

    fun update(speakers : List<Speaker>) {
        speakersData.clear()
        speakersData.addAll(speakers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SpeakersAdapter.ViewHolder {
        val itemBinding = ItemSpeakerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = speakersData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return speakersData.size
    }

    interface OnItemClickListener {
        fun onClick(itemSpeaker : Speaker)
    }

}

