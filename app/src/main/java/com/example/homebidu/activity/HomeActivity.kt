package com.example.homebidu.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homebidu.R
import com.example.homebidu.adapter.*

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var advertisePager: AdvertisePager
    private lateinit var voucherPager: VoucherPager

    private lateinit var itemCategoryAdapter: ItemCategoryAdapter
    private lateinit var topLiveStreamAdapter: TopLiveStreamAdapter
    private lateinit var newProductAdapter: NewProductAdapter
    private lateinit var topKeyAdapter: TopKeyAdapter
    private lateinit var topSellerAdapter: TopSellerAdapter
    private lateinit var topProductAdapter: TopProductAdapter
    private lateinit var suggestProductAdapter: SuggestProductAdapter

    private lateinit var gridLayout: GridLayoutManager
    private lateinit var layoutManagerBidu: LinearLayoutManager
    private lateinit var layoutManagerNewProduct: LinearLayoutManager
    private lateinit var layoutManagerTopKey: LinearLayoutManager
    private lateinit var layoutManagerTopSeller: LinearLayoutManager
    private lateinit var layoutManagerTopProduct: LinearLayoutManager
    private lateinit var layoutManagerSuggestProduct: LinearLayoutManager

    private var timer: Timer? = null
    private var totalAd = 0
    private var totalVoucher = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.activity_main)

        init()
        evenListenObs()

        homeViewModel.getProduct()

        autoSlideImageAd()
        autoSlideImageVoucher()
    }

    private fun evenListenObs() {
        homeViewModel.product.observe(this, { t ->
            when (t) {
                is HomeViewModel.ProductState.Success -> {
                    val banner =
                        t.items.systemBanner?.map { it.imageAds.firstOrNull { it.lang == "vi" }?.detail.orEmpty() }
                    advertisePager.setAdvertisePager(banner.orEmpty())
                    totalAd = banner?.size!!
                }
                is HomeViewModel.ProductState.Error -> Toast.makeText(
                    this,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        homeViewModel.product.observe(this, { t ->
            when (t) {
                is HomeViewModel.ProductState.Success -> itemCategoryAdapter.getItemCategory(t.items.systemCategory.orEmpty())
                is HomeViewModel.ProductState.Error -> Toast.makeText(
                    this,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        homeViewModel.product.observe(this, { t ->
            when (t) {
                is HomeViewModel.ProductState.Success -> {
                    val voucherBanner =
                        t.items.systemBannerVoucher?.map { it.images.firstOrNull { it.lang == "vi" }?.detail.orEmpty() }
                    voucherPager.getVoucher(voucherBanner.orEmpty())
                    totalVoucher = voucherBanner!!.size
                }
                is HomeViewModel.ProductState.Error -> Toast.makeText(
                    this,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        homeViewModel.product.observe(this, { t ->
            when (t) {
                is HomeViewModel.ProductState.Success -> {
                    topLiveStreamAdapter.setTopLiveStream(t.items.topLivestreams.orEmpty())
                }
                is HomeViewModel.ProductState.Error -> Toast.makeText(
                    this,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        homeViewModel.product.observe(this, { t ->
            when (t) {
                is HomeViewModel.ProductState.Success -> {
                    newProductAdapter.getNewProduct(t.items.newestProduct.orEmpty())
                }
                is HomeViewModel.ProductState.Error -> Toast.makeText(
                    this,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        homeViewModel.product.observe(this, { t ->
            when (t) {
                is HomeViewModel.ProductState.Success -> {
                    topKeyAdapter.getTopKey(t.items.topKeyword.orEmpty())
                }

                is HomeViewModel.ProductState.Error -> Toast.makeText(
                    this,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        homeViewModel.product.observe(this, { t ->
            when (t) {
                is HomeViewModel.ProductState.Success -> {
                    topSellerAdapter.getTopSeller(t.items.topShop.orEmpty())
                }
                is HomeViewModel.ProductState.Error -> Toast.makeText(
                    this,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        homeViewModel.product.observe(this, { t ->
            when (t) {
                is HomeViewModel.ProductState.Success -> {
                    topProductAdapter.setTopProduct(t.items.topProduct.orEmpty())
                }

                is HomeViewModel.ProductState.Error -> {
                    Toast.makeText(
                        this, t.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

        homeViewModel.product.observe(this, { t ->
            when (t) {
                is HomeViewModel.ProductState.Success -> {
                    suggestProductAdapter.getSuggestProduct(t.items.suggestProduct.orEmpty())
                }

                is HomeViewModel.ProductState.Error -> {
                    Toast.makeText(
                        this,
                        t.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun init() {
        itemCategoryAdapter = ItemCategoryAdapter()
        gridLayout = GridLayoutManager(this, 5)
        rcvCategory.layoutManager = gridLayout
        rcvCategory.adapter = itemCategoryAdapter

        advertisePager = AdvertisePager()
        voucherPager = VoucherPager()

        viewPagerAd.adapter = advertisePager
        tabLayoutAd.setupWithViewPager(viewPagerAd, true)

        viewPagerVoucher.adapter = voucherPager
        tabLayoutVoucher.setupWithViewPager(viewPagerVoucher, true)

        topLiveStreamAdapter = TopLiveStreamAdapter()
        layoutManagerBidu = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rcvBiDuLive.layoutManager = layoutManagerBidu
        rcvBiDuLive.adapter = topLiveStreamAdapter

        newProductAdapter = NewProductAdapter()
        layoutManagerNewProduct = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rcvNewProduct.layoutManager = layoutManagerNewProduct
        rcvNewProduct.adapter = newProductAdapter

        topKeyAdapter = TopKeyAdapter()
        layoutManagerTopKey = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rcvTopKey.layoutManager = layoutManagerTopKey
        rcvTopKey.adapter = topKeyAdapter

        topSellerAdapter = TopSellerAdapter()
        layoutManagerTopSeller = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rcvTopSeller.layoutManager = layoutManagerTopSeller
        rcvTopSeller.adapter = topSellerAdapter

        topProductAdapter = TopProductAdapter()
        layoutManagerTopProduct = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rcvTopProduct.layoutManager = layoutManagerTopProduct
        rcvTopProduct.adapter = topProductAdapter

        suggestProductAdapter = SuggestProductAdapter()
        layoutManagerSuggestProduct = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rcvSuggest.layoutManager = layoutManagerSuggestProduct
        rcvSuggest.adapter = suggestProductAdapter

    }

    private fun autoSlideImageAd() {
        if (timer == null) {
            timer = Timer()
        }
        timer?.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post {
                    run {
                        var current: Int = viewPagerAd.currentItem
                        if (current < totalAd - 1) {
                            current++
                            viewPagerAd.currentItem = current
                        } else {
                            viewPagerAd.currentItem = 0
                        }
                    }
                }
            }

        }, 500, 4000)
    }

    private fun autoSlideImageVoucher() {
        if (timer == null) {
            timer = Timer()
        }
        timer?.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post {
                    run {
                        var current: Int = viewPagerVoucher.currentItem
                        if (current < totalVoucher - 1) {
                            current++
                            viewPagerVoucher.currentItem = current
                        } else {
                            viewPagerVoucher.currentItem = 0
                        }
                    }
                }
            }

        }, 500, 4000)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
    }
}

