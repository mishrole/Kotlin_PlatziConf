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
import com.mishrole.platziconf.core.entity.Conference
import com.mishrole.platziconf.databinding.FragmentScheduleBinding
import com.mishrole.platziconf.presentation.view.adapter.ScheduleAdapter
import com.mishrole.platziconf.presentation.viewmodel.ConferenceViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScheduleFragment : Fragment() {

    private val conferenceViewModel : ConferenceViewModel by viewModel()
    private var scheduleAdapter = ScheduleAdapter()
    private lateinit var binding : FragmentScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleBinding.inflate(inflater, container, false)

        scheduleAdapter.onItemClickListener = object : ScheduleAdapter.OnItemClickListener {
            override fun onClick(itemConference: Conference) {
                goToSchedule(itemConference)
            }
        }

        binding.rvSchedule.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = scheduleAdapter
        }

        conferenceViewModel.conferencesListResult.observe(viewLifecycleOwner, { conferences ->
            scheduleAdapter.update(conferences)
        })

        conferenceViewModel.loadingStatus.observe(viewLifecycleOwner, {
            binding.progressLayout.root.visibility = if (it) View.VISIBLE else View.GONE
        })

        conferenceViewModel.refreshConferences()

        return binding.root
    }

    private fun goToSchedule(itemConference : Conference) {
        Toast.makeText(context, "Go to Conference from Speaker ${itemConference.speaker}", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.scheduleDetailFragmentDialog, bundleOf("CONFERENCE_ITEM" to itemConference))
    }

}