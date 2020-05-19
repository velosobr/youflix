package com.cursoandroid.youflix.navigationBar.VideosScreen.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.VideosScreen.controller.VideosScreenController

class VideosScreenFragment : Fragment() {

    private lateinit var fragmentContext: Context
    private lateinit var contoller: VideosScreenController
    private lateinit var presenter: VideosScreenPresenterImpl

    override fun onAttach(context: Context) {
        fragmentContext = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos_screen, container, false)
    }


}
