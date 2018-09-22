package `in`.co.ngcapp.ngc.activity

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.ViewPagerAdapter
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar;
import android.support.v4.view.PagerAdapter



class TabLayoutActivity : AppCompatActivity() {

    var toolbar :Toolbar ?= null
    var tabLayout:TabLayout ?= null
    var viewPager:ViewPager ?= null
    var adapter :ViewPagerAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        viewPager = findViewById(R.id.viewpager) as ViewPager

        tabLayout = findViewById(R.id.tabs)

        tabLayout!!.setupWithViewPager(viewPager)
        setPage()

        adapter = ViewPagerAdapter(supportFragmentManager, tabLayout!!.getTabCount())
        viewPager!!.adapter = adapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout!!.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }


    fun setPage(){
        tabLayout!!.addTab(tabLayout!!.newTab().setText("All Friend"))

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Groups"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Favourites"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL;
    }

    //Return current fragment on basis of Position
    fun getFragment(pos: Int): Fragment {
        return adapter?.getItem(pos)!!
    }
}
