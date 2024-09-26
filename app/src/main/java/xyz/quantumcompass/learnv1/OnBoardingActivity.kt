package xyz.quantumcompass.learnv1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import xyz.quantumcompass.learnv1.utils
class OnBoardingActivity : AppCompatActivity() {
    private val onBoardingPageChangeCallBack = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            when(position){
                0->{
                    skipBtn.text = "Skip"
                    skipBtn.visibility = View.VISIBLE
                    nextBtn.visibility = View.VISIBLE
                    prevBtn.visibility = View.GONE

                }
                1->{
                    skipBtn.text = "Get Started"
                    skipBtn.visibility = View.GONE
                    nextBtn.visibility = View.VISIBLE
                    prevBtn.visibility = View.VISIBLE
                }
                else->{
                    skipBtn.text = "Skip"
                    skipBtn.visibility = View.VISIBLE
                    nextBtn.visibility = View.VISIBLE
                    prevBtn.visibility = View.VISIBLE

                }
            }
        }
    }
    private val pagerList = arrayListOf(

        Page(
            "Unlock Your Potential: Learn Blockchain Development",
            R.drawable.dragon,
            "Start your journey with beginner-friendly lessons. Learn at your own pace and earn digital points while mastering blockchain concepts.",
            "#FFBE38"
        ),
        Page(
            "Master Blockchain Development for Top Cryptocurrencies",
            R.drawable.dragon,
            "Gain advanced skills in developing blockchain solutions for top cryptocurrencies like Bitcoin, Ethereum, and more.",
            "#03A9F4"
        ),
        Page(
            "Ascend: Empower Yourself Through Learning",
            R.drawable.dragon,
            "Experience true empowerment by learning blockchain technology and unlocking your potential to build decentralized applications.",
            "#FF9800"
        )


    )
    lateinit var onBoardingViewPager2: ViewPager2
    lateinit var skipBtn: Button
    lateinit var prevBtn: Button
    lateinit var nextBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding)
        onBoardingViewPager2 = findViewById(R.id.onBoardingViewPager2)
        skipBtn = findViewById(R.id.skipButton)
        prevBtn = findViewById(R.id.previousButton)
        nextBtn = findViewById(R.id.nextButton)

        onBoardingViewPager2.apply {
            adapter = OnBoardingAdapter(this@OnBoardingActivity,pagerList)
            registerOnPageChangeCallback(onBoardingPageChangeCallBack)
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, onBoardingViewPager2){tab, position ->}.attach()

        nextBtn.setOnClickListener{
if (onBoardingViewPager2.currentItem < onBoardingViewPager2.adapter!!.itemCount-1){
    onBoardingViewPager2.currentItem+=1
}else{
    homeScreenIntent()
}
        }
        skipBtn.setOnClickListener{
            onBoardingViewPager2.unregisterOnPageChangeCallback(onBoardingPageChangeCallBack)
homeScreenIntent()
        }
        prevBtn.setOnClickListener{
if (onBoardingViewPager2.currentItem>0){
    onBoardingViewPager2.currentItem -= 1

}
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    private fun homeScreenIntent() {
       val homeIntent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)
    }
}