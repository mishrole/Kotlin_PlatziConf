package com.mishrole.platziconf.presentation.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mishrole.platziconf.R
import com.mishrole.platziconf.core.entity.Speaker
import com.mishrole.platziconf.databinding.FragmentSpeakersBinding
import com.mishrole.platziconf.presentation.view.adapter.SpeakersAdapter
import com.mishrole.platziconf.presentation.viewmodel.SpeakerViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpeakersFragment : Fragment() {

    private val speakerViewModel : SpeakerViewModel by viewModel()
    private var speakersAdapter = SpeakersAdapter()
    private lateinit var binding : FragmentSpeakersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpeakersBinding.inflate(inflater, container, false)

        speakersAdapter.onItemClickListener = object : SpeakersAdapter.OnItemClickListener {
            override fun onClick(itemSpeaker: Speaker) {
                goToSpeaker(itemSpeaker)
            }
        }

        binding.rvSpeakers.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = speakersAdapter
        }

        speakerViewModel.speakersListResult.observe(viewLifecycleOwner, { speakers ->
            speakersAdapter.update(speakers)
        })

        speakerViewModel.loadingStatus.observe(viewLifecycleOwner, {
            binding.progressLayout.root.visibility = if (it) View.VISIBLE else View.GONE
        })

        speakerViewModel.refreshSpeakers()

        return binding.root
    }

    private fun goToSpeaker(itemSpeaker: Speaker) {
        findNavController().navigate(R.id.speakersDetailFragmentDialog, bundleOf("SPEAKER_ITEM" to itemSpeaker))
    }

}