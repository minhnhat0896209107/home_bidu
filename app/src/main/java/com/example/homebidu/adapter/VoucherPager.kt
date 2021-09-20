package com.example.homebidu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.homebidu.R

class VoucherPager : PagerAdapter() {
    private val items = mutableListOf<String>()
    fun getVoucher(items: List<String>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_voucher, container, false)

        val ivVoucher : ImageView = view.findViewById(R.id.ivVoucher)

        val data = items[position]
            Glide.with(ivVoucher)
                .load(data)
                .error(R.mipmap.ic_launcher)
                .into(ivVoucher)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}