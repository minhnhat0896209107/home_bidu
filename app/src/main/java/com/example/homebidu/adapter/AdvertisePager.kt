package com.example.homebidu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.homebidu.R
import com.example.homebidu.pojo.model.ImageAd
import com.example.homebidu.pojo.model.SystemBanner

class AdvertisePager : PagerAdapter() {
    private val images = mutableListOf<String>()

    fun setAdvertisePager(listAd: List<String>) {
        this.images.addAll(listAd)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(container.context)
            .inflate(R.layout.item_advertise, container, false)
        val ivAdvertise: ImageView = view.findViewById(R.id.ivAdvertise)
        val data = images[position]
            Glide.with(ivAdvertise)
                .load(data)
                .error(R.mipmap.ic_launcher)
                .into(ivAdvertise)
        container.addView(view)
        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}