package com.example.earlylife

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.util.ArrayList

class RadarChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radar_chart)
        val radarChart = findViewById<RadarChart>(R.id.radarChart)
        val times = ArrayList<RadarEntry>()
        times.add(RadarEntry(10101f))
        times.add(RadarEntry(7198f))
        times.add(RadarEntry(9871f))
        times.add(RadarEntry(8087f))


//        ArrayList<RadarEntry> numbersTimes = new ArrayList<>();
//        numbersTimes.add(new RadarEntry(4321));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//
//        ArrayList<RadarEntry> shapesTimes = new ArrayList<>();
//        shapesTimes.add(new RadarEntry(0));
//        shapesTimes.add(new RadarEntry(6543));
//        shapesTimes.add(new RadarEntry(0));
//        shapesTimes.add(new RadarEntry(0));
//        shapesTimes.add(new RadarEntry(0));
//        shapesTimes.add(new RadarEntry(730));
//        shapesTimes.add(new RadarEntry(200));
//
//        ArrayList<RadarEntry> loveTimes = new ArrayList<>();
//        loveTimes.add(new RadarEntry(0));
//        loveTimes.add(new RadarEntry(0));
//        loveTimes.add(new RadarEntry(10987));
//        loveTimes.add(new RadarEntry(0));
//        loveTimes.add(new RadarEntry(160));
//        loveTimes.add(new RadarEntry(30));
//        loveTimes.add(new RadarEntry(365));
//
//        ArrayList<RadarEntry> miscTimes = new ArrayList<>();
//        miscTimes.add(new RadarEntry(0));
//        miscTimes.add(new RadarEntry(0));
//        miscTimes.add(new RadarEntry(0));
//        miscTimes.add(new RadarEntry(5678));
//        miscTimes.add(new RadarEntry(660));
//        miscTimes.add(new RadarEntry(20));
//        miscTimes.add(new RadarEntry(0));
        val radarDataSetForTimes = RadarDataSet(times, "TIME(MINUTES)")
        radarDataSetForTimes.color = Color.BLUE
        radarDataSetForTimes.lineWidth = 2f
        radarDataSetForTimes.valueTextColor = Color.BLUE
        radarDataSetForTimes.valueTextSize = 14f


//
//
//
//        RadarDataSet radarDataSetForNumbers = new RadarDataSet(numbersTimes,"LOVE");
//        radarDataSetForNumbers.setColor(Color.RED);
//        radarDataSetForNumbers.setLineWidth(2f);
//        radarDataSetForNumbers.setValueTextColor(Color.RED);
//        radarDataSetForNumbers.setValueTextSize(14f);
//
//        RadarDataSet radarDataSetForShapes = new RadarDataSet(shapesTimes,"MISCELLANEOUS");
//        radarDataSetForShapes.setColor(Color.BLUE);
//        radarDataSetForShapes.setLineWidth(2f);
//        radarDataSetForShapes.setValueTextColor(Color.BLUE);
//        radarDataSetForShapes.setValueTextSize(14f);
//
//        RadarDataSet radarDataSetForLove = new RadarDataSet(loveTimes,"NUMBERS");
//        radarDataSetForLove.setColor(Color.MAGENTA);
//        radarDataSetForLove.setLineWidth(2f);
//        radarDataSetForLove.setValueTextColor(Color.MAGENTA);
//        radarDataSetForLove.setValueTextSize(14f);
//
//        RadarDataSet radarDataSetForMisc = new RadarDataSet(miscTimes,"SHAPES");
//        radarDataSetForMisc.setColor(Color.GREEN);
//        radarDataSetForMisc.setLineWidth(2f);
//        radarDataSetForMisc.setValueTextColor(Color.GREEN);
//        radarDataSetForMisc.setValueTextSize(14f);
        val radarData = RadarData()
        radarData.addDataSet(radarDataSetForTimes)
        //        radarData.addDataSet(radarDataSetForNumbers);
//        radarData.addDataSet(radarDataSetForShapes);
//        radarData.addDataSet(radarDataSetForLove);
//        radarData.addDataSet(radarDataSetForMisc);
        val labels = arrayOf("LOVE", "MISC", "NUMBERS", "SHAPES")
        val xAxis = radarChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        xAxis.axisLineColor = Color.BLACK
        xAxis.gridColor = Color.BLACK
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            radarChart.background = getDrawable(R.drawable.elephantstars)
        } else {
            radarChart.setBackgroundColor(Color.WHITE)
        }
        radarChart.description.text = "Time spent on each activity illustrated as radar chart"
        radarChart.description.textColor = Color.BLUE
        radarChart.description.textSize = 14f
        //radarChart.getDescription().setPosition(900,50);
        radarChart.data = radarData
        radarChart.animateXY(2000, 2000)
    }
}