package xyz.quantumcompass.learnv1

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OnboardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnboardingFragment(val page: Page) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_onboarding, container, false)
        view.setBackgroundColor(Color.parseColor(page.color))
        val titleText = view.findViewById<TextView>(R.id.titleTxt)
        val descText = view.findViewById<TextView>(R.id.descTxt)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
    titleText.text = page.title
        descText.text = page.desc
        imageView.setImageResource(page.image)


        return  view
    }

}