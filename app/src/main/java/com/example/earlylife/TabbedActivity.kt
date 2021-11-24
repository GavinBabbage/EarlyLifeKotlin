//package com.example.earlylife
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.viewpager2.widget.ViewPager2
//import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
//import com.google.android.material.tabs.TabLayout
//import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
//import com.google.android.material.tabs.TabLayoutMediator
//
//class TabbedActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_tabbed)
//
//        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
//        val pager2 = findViewById<ViewPager2>(R.id.view_pager2)
//        val adapter = FragmentAdapter(supportFragmentManager, lifecycle)
//
//        pager2.adapter = adapter
//
//        TabLayoutMediator(tabLayout,pager2){tab,position->
//            when(position){
//                0-> tab.text = "Activities"
//                1-> tab.text = "Statistics"
//                2-> tab.text = "Help"
//            }
//        }.attach()
//    }
//}

package com.example.earlylife

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class TabbedActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var pager2: ViewPager2? = null
    var adapter: FragmentAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabbed)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val pager2 = findViewById<ViewPager2>(R.id.view_pager2)
        val fm = supportFragmentManager
        val adapter = FragmentAdapter(fm, lifecycle)
        pager2.adapter=adapter

        TabLayoutMediator(tabLayout,pager2){tab,position->
            when(position){
                0-> tab.text = "Activities"
                1-> tab.text = "Statistics"
                2-> tab.text = "Help"
            }
        }.attach()




        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager2.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        pager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}