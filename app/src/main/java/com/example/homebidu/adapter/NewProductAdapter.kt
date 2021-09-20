package com.example.homebidu.adapter

import android.annotation.SuppressLint
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homebidu.R
import com.example.homebidu.pojo.model.NewestProduct
import kotlinx.android.synthetic.main.item_new_product.view.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class NewProductAdapter : RecyclerView.Adapter<NewProductAdapter.ItemNewProductVH>(){

    private val items = mutableListOf<NewestProduct>()

    fun getNewProduct(items: List<NewestProduct>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ItemNewProductVH(view : View) : RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bind(data : NewestProduct){
            itemView.apply {
                Glide.with(ivNewProduct)
                    .load(data.images.firstOrNull())
                    .error(R.mipmap.ic_launcher)
                    .into(ivNewProduct)
                tvNameNewProduct.text = data.name
               val decimalFormat =  DecimalFormat("###,###,###")
                tvPriceNewProduct.text = decimalFormat.format(data.beforeSalePrice).plus(" ₫")
                if (data.shop.country == "KO"){
                    tvCountry.text = "Hàn Quốc"
                }else if(data.shop.country == "VN"){
                    tvCountry.text = "Việt Nam"
                }else{
                    tvCountry.text = "Mỹ"
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemNewProductVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_product, parent, false)
        return ItemNewProductVH(view)
    }

    override fun onBindViewHolder(holder: ItemNewProductVH, position: Int) {
        items.let { holder.bind(it[position]) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}