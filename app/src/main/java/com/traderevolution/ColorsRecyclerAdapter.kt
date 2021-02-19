package com.traderevolution

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.traderevolution.data.Color
import com.traderevolution.databinding.ColorItemBinding


class ColorsRecyclerAdapter(private val items: List<Color>) :
    RecyclerView.Adapter<ColorsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ColorItemBinding = DataBindingUtil.inflate(inflater, R.layout.color_item, parent, false)
        binding.adapter = this
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    fun itemSelected(color: Color) {
        color.expanded.set(!color.expanded.get())
    }


    inner class ViewHolder(private val binding: ColorItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(color: Color) {
            binding.color = color
            binding.executePendingBindings()
        }
    }

}