package com.example.earlylife

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [StatisticsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatisticsFragment : Fragment(), View.OnClickListener {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_statistics, container, false);
        val v: View = inflater.inflate(R.layout.fragment_statistics, container, false)
        val pieGenerator = v.findViewById<View>(R.id.Generate_Pie_button) as Button
        val barGenerator = v.findViewById<View>(R.id.Generate_Bar_button) as Button
        val radarGenerator = v.findViewById<View>(R.id.Generate_Radar_button) as Button
        pieGenerator.setOnClickListener(this)
        barGenerator.setOnClickListener(this)
        radarGenerator.setOnClickListener(this)
        return v
    }

    override fun onClick(v: View) {
//        Intent intent = new Intent(getActivity(),PieChartActivity.class);
//        startActivity(intent);
        when (v.id) {
            R.id.Generate_Pie_button -> {
                //generate pie button clicked
                val pieIntent = Intent(activity, PieChartActivity::class.java)
                startActivity(pieIntent)
            }
            R.id.Generate_Bar_button -> {
                // generate bar button clicked
                val barIntent = Intent(activity, BarChartActivity::class.java)
                startActivity(barIntent)
            }
            R.id.Generate_Radar_button -> {
                // generate radar button clicked
                val radarIntent = Intent(activity, RadarChartActivity::class.java)
                startActivity(radarIntent)
            }
        }
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StatisticsFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): StatisticsFragment {
            val fragment = StatisticsFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}