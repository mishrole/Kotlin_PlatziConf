package com.mishrole.platziconf.presentation.view.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.mishrole.platziconf.R
import com.mishrole.platziconf.core.entity.Conference
import com.mishrole.platziconf.databinding.FragmentScheduleDetailDialogBinding
import java.text.SimpleDateFormat
import java.util.*

class ScheduleDetailDialogFragment : DialogFragment() {

    private lateinit var binding : FragmentScheduleDetailDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleDetailDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarConference.navigationIcon = ContextCompat.getDrawable(binding.root.context, R.drawable.ic_icons_close)
        binding.toolbarConference.navigationIcon?.setTint(Color.WHITE)
        binding.toolbarConference.setTitleTextColor(Color.WHITE)
        binding.toolbarConference.setNavigationOnClickListener {
            dismissAllowingStateLoss()
        }

        val conference = arguments?.getSerializable("CONFERENCE_ITEM") as Conference

        binding.toolbarConference.title = conference.title
        binding.tvItemScheduleTitle.text = conference.title
        binding.tvDetailsConferenceSpeaker.text = conference.speaker
        binding.tvDetailsConferenceHour.text = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale("es", "PE")).format(conference.datetime)
        binding.tvDetailsConferenceTag.text = conference.tag
        binding.tvDetailsConferenceDescription.text = conference.description
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}