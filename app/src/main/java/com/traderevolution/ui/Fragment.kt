package com.traderevolution.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.traderevolution.ColorsRecyclerAdapter
import com.traderevolution.ColorsViewModel
import com.traderevolution.R
import com.traderevolution.data.Color

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val model: ColorsViewModel by activityViewModels()
        model.getColors().observe(viewLifecycleOwner, Observer<List<Color>>{ colors ->
            recyclerView.adapter = ColorsRecyclerAdapter(colors)
        })
    }
}