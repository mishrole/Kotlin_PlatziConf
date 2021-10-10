package com.mishrole.platziconf.presentation.view.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mishrole.platziconf.R
import com.mishrole.platziconf.core.entity.Speaker
import com.mishrole.platziconf.databinding.FragmentSpeakersDetailDialogBinding

class SpeakersDetailDialogFragment : DialogFragment() {

    private lateinit var binding : FragmentSpeakersDetailDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpeakersDetailDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarSpeakers.navigationIcon = ContextCompat.getDrawable(binding.root.context, R.drawable.ic_icons_close)
        binding.toolbarSpeakers.navigationIcon?.setTint(Color.WHITE)
        binding.toolbarSpeakers.setTitleTextColor(Color.WHITE)
        binding.toolbarSpeakers.setNavigationOnClickListener {
            dismissAllowingStateLoss()
        }

        val speaker = arguments?.getSerializable("SPEAKER_ITEM") as Speaker

        Glide.with(this.requireContext())
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.ivSpeakerImage)

        binding.toolbarSpeakers.title = speaker.name
        binding.tvSpeakerName.text = speaker.name
        binding.tvSpeakerJobTitle.text = speaker.jobTitle
        binding.tvSpeakerWork.text = speaker.workPlace
        binding.tvSpeakerDescription.text = speaker.biography
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
    
}