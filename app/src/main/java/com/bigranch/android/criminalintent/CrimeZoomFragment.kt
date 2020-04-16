package com.bigranch.android.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import java.io.File

private const val PHOTO_FILE = "photo_file"

class CrimeZoomFragment: Fragment() {
    private lateinit var photoView: ImageView
    private lateinit var photoContainer: ConstraintLayout

    private lateinit var photoFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoFile = arguments?.getSerializable(PHOTO_FILE) as File
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime_photo_zoom, container, false)

        photoView = view.findViewById(R.id.crime_photo_zoom) as ImageView
        photoContainer = view.findViewById(R.id.zoom_photo) as ConstraintLayout

        return view
    }

    override fun onStart() {
        super.onStart()

        photoView.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        photoContainer.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updatePhotoView()
    }

    private fun updatePhotoView() {
        if (photoFile.exists()) {
            val bitmap = getScaledBitmap(photoFile.path, requireActivity())
            photoView.setImageBitmap(bitmap)
        } else {
            photoView.setImageDrawable(null)
        }
    }

    companion object {
        fun newInstance(photoFile: File): CrimeZoomFragment {
            val args = Bundle().apply {
                putSerializable(PHOTO_FILE, photoFile)
            }
            return CrimeZoomFragment().apply { arguments = args}
        }
    }
}