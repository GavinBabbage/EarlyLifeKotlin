package com.example.earlylife

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.ArrayList

class BarChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_chart)
        val barChart = findViewById<BarChart>(R.id.barChart)
        val labels = ArrayList<String>()
        labels.add("")
        labels.add("LOVE")
        labels.add("MISC")
        labels.add("NUMBERS")
        labels.add("SHAPES")

        //barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        val xAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.TOP_INSIDE
        xAxis.setDrawLabels(true)
        xAxis.granularity = 1f
        //xAxis.setLabelRotationAngle(+90);
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        val activityTimes = ArrayList<BarEntry>()
        //activityTimes.add(new BarEntry(Float.parseFloat(barChart.getXAxis().getFormattedLabel(0)),420));
        activityTimes.add(BarEntry(1f, 475f))
        activityTimes.add(BarEntry(2f, 475f))
        activityTimes.add(BarEntry(3f, 508f))
        activityTimes.add(BarEntry(4f, 660f))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            barChart.background = getDrawable(R.drawable.elephantstars)
        } else {
            barChart.setBackgroundColor(Color.WHITE)
        }
        val barDataSet = BarDataSet(activityTimes, "TIME SPENT(MINUTES)")
        barDataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 16f
        val barData = BarData(barDataSet)
        barChart.setFitBars(true)
        barChart.data = barData
        barChart.description.text = "Time spent on each activity illustrated as bar chart"
        barChart.description.textSize = 14f
        barChart.animateXY(2000,2000)
    }
}