package com.cursoandroid.youflix.Listeners

import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView


class RecyclerItemClickListener : RecyclerView.OnItemTouchListener {
    private var mListener: OnItemClickListener? = null
    private var mGestureDetector: GestureDetector? = null

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        TODO("Not yet implemented")

    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        TODO("Not yet implemented")
    }


    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("Not yet implemented")
    }

}