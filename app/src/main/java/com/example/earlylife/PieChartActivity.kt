package com.example.earlylife

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.ArrayList

class PieChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)
        val pieChart = findViewById<PieChart>(R.id.pieChart)
        val activityTimes: ArrayList<PieEntry?> = ArrayList<PieEntry?>()
        activityTimes.add(PieEntry(600f, "LOVE"))
        activityTimes.add(PieEntry(508f, "MISC"))
        activityTimes.add(PieEntry(750f, "NUMBERS"))
        activityTimes.add(PieEntry(400f, "SHAPES"))
        val pieDataSet = PieDataSet(activityTimes, "TIME SPENT(MINUTES)")
        pieDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.valueTextSize = 16f
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            pieChart.background = getDrawable(R.drawable.elephantstars)
        } else {
            pieChart.setBackgroundColor(Color.WHITE)
        }
        val pieData = PieData(pieDataSet)
        pieChart.data = pieData
        pieChart.description.text = "Time spent on each activity illustrated as pie chart"
        pieChart.description.textSize = 14f
        pieChart.centerText = "TIME SPENT(MINUTES)"
        pieChart.animateXY(2000, 2000)
    }
}