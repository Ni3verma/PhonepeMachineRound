package com.andryoga.phonepenitin.ui.util

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.andryoga.phonepenitin.R
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context).asDrawable().load(url)
            .override(40, 80)
            .fitCenter()
            .placeholder(R.drawable.ic_launcher_background)
            .error(ColorDrawable(Color.RED))
            .into(view)
    }
}