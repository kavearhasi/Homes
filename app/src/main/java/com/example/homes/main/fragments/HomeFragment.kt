package com.example.homes.main.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.homes.R
import com.example.homes.home.adapters.BannerAdapter
import com.example.homes.home.adapters.ExplosionAdapter
import com.example.homes.home.adapters.SliderAdapter
import com.example.homes.home.data.Explosion
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var viewPagerSlider: ViewPager2
    private lateinit var viewPagerBanner: ViewPager2
    private lateinit var viewPagerExplosion: ViewPager2

    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var explosionAdapter: ExplosionAdapter

    private lateinit var index1: ImageView
    private lateinit var index2: ImageView
    private lateinit var index3: ImageView
    private lateinit var index4: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageSlider = listOf(
            R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4
        )
        val imageBanner = listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
            R.drawable.banner4
        )

        val explosions = listOf(
            Explosion(R.drawable.explosion1, "Modern Minimalist Sofa"),
            Explosion(R.drawable.explosion2, "Rustic Charm Dining Set"),
            Explosion(R.drawable.explosion3, "Cozy Corner Reading Nook"),
            Explosion(R.drawable.explosion4, "Industrial Chic Bookshelf"),
            Explosion(R.drawable.explosion5, "Elegant Upholstered Headboard"),
            Explosion(R.drawable.explosion6, "Mid-Century Modern Accent Chair"),
            Explosion(R.drawable.explosion7, "Outdoor Oasis Patio Furniture"),
            Explosion(R.drawable.explosion8, "Space-Saving Murphy Bed Design"),

            )

        initSliders(view)

        initAdapters(imageSlider, imageBanner, explosions)

        initViewPagerAdapters()

        initIndex(view)

        viewPagerSlider.autoScroll(lifecycleScope, 8000)

        val slideNext = view.findViewById<Button>(R.id.nextSlide)
        val explosionNext = view.findViewById<Button>(R.id.nextExplosion)

        viewPagerSlider.registerOnPageChangeCallback(createOnPageCallback())

        slideNext.setOnClickListener {
            viewPagerBanner.advanceBanner(1)
        }

        explosionNext.setOnClickListener {
            viewPagerExplosion.advanceBanner(2)
        }
        viewPagerExplosion.apply {
            offscreenPageLimit = 3


        }
    }


    private fun ViewPager2.autoScroll(lifeCycleScope: LifecycleCoroutineScope, interval: Long) {
        lifeCycleScope.launch {
            scrollIndefinitely(interval)
        }
    }


    private suspend fun ViewPager2.scrollIndefinitely(interval: Long) {
        delay(interval)
        viewPagerSlider.advanceBanner(1)
        scrollIndefinitely(interval)
    }


    private fun changeColor() {
        when (viewPagerSlider.currentItem) {
            0 -> {
                index1.setImageResource(R.drawable.active_circle)
                index2.setImageResource(R.drawable.outline_circle)
                index3.setImageResource(R.drawable.outline_circle)
                index4.setImageResource(R.drawable.outline_circle)
            }

            1 -> {
                index1.setImageResource(R.drawable.outline_circle)
                index2.setImageResource(R.drawable.active_circle)
                index3.setImageResource(R.drawable.outline_circle)
                index4.setImageResource(R.drawable.outline_circle)
            }

            2 -> {
                index1.setImageResource(R.drawable.outline_circle)
                index2.setImageResource(R.drawable.outline_circle)
                index3.setImageResource(R.drawable.active_circle)
                index4.setImageResource(R.drawable.outline_circle)
            }

            3 -> {
                index1.setImageResource(R.drawable.outline_circle)
                index2.setImageResource(R.drawable.outline_circle)
                index3.setImageResource(R.drawable.outline_circle)
                index4.setImageResource(R.drawable.active_circle)
            }
        }
    }


    private fun ViewPager2.advanceBanner(item:Int) {
        val adapter = this.adapter
        if (adapter != null) {
            val numberOfItems = adapter.itemCount ?: 0
            val lastIndex = if (numberOfItems > 0) numberOfItems - 1 else 0
            val nextItem = if (currentItem == lastIndex) 0 else currentItem + item
            setCurrentItem(nextItem, true)
        }
    }

    private fun initSliders(view: View) {
        viewPagerSlider = view.findViewById(R.id.headerSlider)
        viewPagerBanner = view.findViewById(R.id.bannerSlider)
        viewPagerExplosion = view.findViewById(R.id.explosionSlider)

    }

    private fun initAdapters(image1: List<Int>, image2: List<Int>, explosion: List<Explosion>) {
        sliderAdapter = SliderAdapter(image1)
        bannerAdapter = BannerAdapter(image2)
        explosionAdapter = ExplosionAdapter(explosion)
    }

    private fun initViewPagerAdapters() {
        viewPagerSlider.adapter = sliderAdapter
        viewPagerBanner.adapter = bannerAdapter
        viewPagerExplosion.adapter = explosionAdapter
    }

    private fun initIndex(view: View) {
        index1 = view.findViewById(R.id.indicator1)
        index2 = view.findViewById(R.id.indicator2)
        index3 = view.findViewById(R.id.indicator3)
        index4 = view.findViewById(R.id.indicator4)
    }


    private fun createOnPageCallback(): ViewPager2.OnPageChangeCallback {
        return object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int, positionOffset: Float, positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                changeColor()
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }
        }
    }



}