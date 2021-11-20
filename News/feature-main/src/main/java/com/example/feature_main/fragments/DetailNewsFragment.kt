package com.example.feature_main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.feature_main.HomeActivity
import com.example.feature_main.R
import com.squareup.picasso.Picasso

class DetailNewsFragment: Fragment() {
    private lateinit var detailImage: ImageView
    private lateinit var detailTitle: TextView
    private lateinit var detailDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_details_fragment, container, false)

        detailImage = view.findViewById(R.id.detail_image_view) as ImageView
        detailTitle = view.findViewById(R.id.detail_title) as TextView
        detailDescription = view.findViewById(R.id.detail_description) as TextView

        // Inflate the layout for this fragment
        startProgram()

        return view
    }

    /*
    * This function builds all functions
    * */
    private fun startProgram() {
        showDetailImage()
        showDetailTitle()
        showDetailDescription()
    }

    private fun showDetailImage() {
        Picasso.get()
            .load((requireActivity() as HomeActivity).detailNewsIconLinc)
            .into(detailImage)
    }

    private fun showDetailTitle() {
        detailTitle.text = (requireActivity() as HomeActivity).detailNewsTitle
    }

    private fun showDetailDescription() {
        detailDescription.text = (requireActivity() as HomeActivity).detailNewsDescription
    }
}