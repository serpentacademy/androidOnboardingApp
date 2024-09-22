package xyz.quantumcompass.learnv1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnBoardingActivity : AppCompatActivity() {
    private val pagerList = arrayListOf(
        Page("Study Hard and Learn to Earn", R.drawable.dragon,"From beginner frendly lessons, classes. Learn at your own peace while earning digital points.", "#FFBE38"),
        Page("Master Blockchain Development of Top Crypto", R.drawable.dragon,"", "#03A9F4"),
        Page("Ascend by Learn, True empowerment through learning", R.drawable.dragon,"", "#FF9800")



    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}