package com.mishrole.platziconf.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mishrole.platziconf.databinding.ItemScheduleBinding
import com.mishrole.platziconf.core.entity.Conference
import java.text.SimpleDateFormat
import java.util.*

class ScheduleAdapter (
    private val conferencesData : MutableList<Conference> = mutableListOf()
) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    var onItemClickListener : OnItemClickListener? = null

    inner class ViewHolder (
        private val itemBinding : ItemScheduleBinding
        ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(conference : Conference) {
            itemBinding.tvItemScheduleConferenceName.text = conference.title
            itemBinding.tvItemScheduleConferenceSpeaker.text = conference.speaker
            itemBinding.tvItemScheduleHour.text = SimpleDateFormat("HH:mm", Locale("es", "PE")).format(conference.datetime)
            itemBinding.tvItemScheduleHourAMPM.text = SimpleDateFormat("a", Locale("es", "PE")).format(conference.datetime).uppercase()
            itemBinding.tvItemScheduleTag.text = conference.tag

            itemBinding.root.setOnClickListener {
                onItemClickListener?.onClick(conference)
            }
        }

    }

    fun update(conferences : List<Conference>) {
        conferencesData.clear()
        conferencesData.addAll(conferences)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder (
        parent: ViewGroup,
        viewType: Int
    ): ScheduleAdapter.ViewHolder {
        val itemBinding = ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        val item = conferencesData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return conferencesData.size
    }

    interface OnItemClickListener {
        fun onClick(itemConference : Conference)
    }

}