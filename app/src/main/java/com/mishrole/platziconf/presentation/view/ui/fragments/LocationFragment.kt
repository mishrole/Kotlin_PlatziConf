package com.mishrole.platziconf.presentation.view.ui.fragments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import com.mishrole.platziconf.core.entity.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*
import com.mishrole.platziconf.R
import com.mishrole.platziconf.databinding.FragmentLocationBinding

class LocationFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var binding : FragmentLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map_location) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        val location = Location()
        val zoom = 16f
        val center = LatLng(location.latitude, location.longitude)

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, zoom))

        val markerOptions = MarkerOptions()
        markerOptions.position(center)
        markerOptions.title("Platzi Conf")

        val bitmap = requireContext().applicationContext.let {
            ContextCompat.getDrawable(it, R.drawable.logo_platzi)
        } as BitmapDrawable
        val smallMarker = Bitmap.createScaledBitmap(bitmap.bitmap, 150, 150, false)

        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))

        googleMap.addMarker(markerOptions)
        googleMap.setOnMarkerClickListener(this)
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.custom_map))

    }

    override fun onMarkerClick(googleMap: Marker): Boolean {
        findNavController().navigate(R.id.locationDetailFragmentDialog)
        return true
    }

}