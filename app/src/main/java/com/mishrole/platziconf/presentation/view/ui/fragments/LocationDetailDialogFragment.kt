package com.mishrole.platziconf.presentation.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.mishrole.platziconf.R
import com.mishrole.platziconf.core.entity.Location
import com.mishrole.platziconf.databinding.FragmentLocationDetailDialogBinding

class LocationDetailDialogFragment : DialogFragment() {

    private lateinit var binding : FragmentLocationDetailDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationDetailDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarLocation.navigationIcon = ContextCompat.getDrawable(binding.root.context, R.drawable.ic_icons_close)
        binding.toolbarLocation.navigationIcon?.setTint(Color.WHITE)
        binding.toolbarLocation.setTitleTextColor(Color.WHITE)
        binding.toolbarLocation.setNavigationOnClickListener {
            dismissAllowingStateLoss()
        }

        val location = Location()

        binding.toolbarLocation.title = location.name
        binding.tvDetailsLocationAddress.text = location.address
        binding.tvDetailsLocationLink.text = location.website
        binding.tvDetailsLocationPhone.text = location.phone
        binding.tvDetailsLocationName.text = location.name

        binding.tvDetailsLocationPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${location.phone}")
            }
            startActivity(intent)
        }

        binding.tvDetailsLocationLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(location.website)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}