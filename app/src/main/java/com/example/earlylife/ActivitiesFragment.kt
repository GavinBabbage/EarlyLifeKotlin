package com.example.earlylife

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.transition.TransitionManager.beginDelayedTransition
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_activities.*
import java.util.ArrayList
import android.widget.Button as Button1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActivitiesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActivitiesFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString(ARG_PARAM1)
            mParam2 = requireArguments().getString(ARG_PARAM2)
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_activities, container, false)
        val shapesActivityGenerator = v.findViewById<View>(R.id.shapes_button) as ImageButton
        val numbersActivityGenerator = v.findViewById<View>(R.id.numbers_button) as ImageButton
        val loveActivityGenerator = v.findViewById<View>(R.id.love_button) as ImageButton
        val miscActivityGenerator = v.findViewById<View>(R.id.misc_button) as ImageButton

        shapesActivityGenerator.setOnClickListener(this)
        numbersActivityGenerator.setOnClickListener(this)
        loveActivityGenerator.setOnClickListener(this)
        miscActivityGenerator.setOnClickListener(this)

        return v
    //return inflater.inflate(R.layout.fragment_activities, container, false)

    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.shapes_button -> {
                //generate pie button clicked
                val shapesIntent = Intent(activity, ShapesActivity::class.java)
                startActivity(shapesIntent)
            }
            R.id.numbers_button -> {
                // generate bar button clicked
                val numbersIntent = Intent(activity, NumbersActivity::class.java)
                startActivity(numbersIntent)
            }
            R.id.love_button -> {
                // generate radar button clicked
                val loveIntent = Intent(activity, LoveActivity::class.java)
                startActivity(loveIntent)
            }
            R.id.misc_button -> {
                // generate radar button clicked
                val miscIntent = Intent(activity, MiscActivity::class.java)
                startActivity(miscIntent)
            }
        }

    }



//    private fun ImageButton.setOnClickListener(v: View) {
//
//    }
//




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ActivitiesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActivitiesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}

