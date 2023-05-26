package com.example.customtablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private var tabLayout: TabLayout? = null
    private var viewPager2: ViewPager2? = null
    private var adapter: MyFragmentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        tabLayout?.addTab(tabLayout!!.newTab().setText("Sign In"))
        tabLayout?.addTab(tabLayout!!.newTab().setText("Sign Up"))
        val fragmentManager = supportFragmentManager
        adapter = MyFragmentAdapter(fragmentManager, lifecycle)
        viewPager2?.setAdapter(adapter)
        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2?.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewPager2?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout?.let {
                    it.selectTab(it.getTabAt(position))
                }
            }
        })
    }
}
