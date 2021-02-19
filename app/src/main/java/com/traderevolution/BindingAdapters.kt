package com.traderevolution

import android.graphics.drawable.GradientDrawable
import android.widget.RelativeLayout
import androidx.databinding.BindingAdapter
import com.traderevolution.data.Color

@BindingAdapter("app:isExpanded", "app:color")
fun backgroundColorChange(view: RelativeLayout, isExpanded: Boolean, color: Color) {
    val shape: GradientDrawable = view.background as GradientDrawable
    shape.setColor(android.graphics.Color.parseColor(if (isExpanded) color.code else "#575555"))
}