package `in`.co.ngcapp.ngc.fragments

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.ViewPagerAdapter
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CallLogFragment : Fragment() {


    var toolbar: Toolbar? = null
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var titleTextView: TextView? = null
    var countTextView: TextView? = null

    var titles = arrayOf("All Logs", "Missed Call")
    var counts = arrayOf("", "")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_tab_layout, container, false)
        toolbar = view.findViewById(R.id.toolbar) as Toolbar

        tabLayout = view!!.findViewById(R.id.tabs)
        setPage()
        viewPager = view.findViewById(R.id.viewpager) as ViewPager
        titleTextView = view.findViewById(R.id.title)
        countTextView = view.findViewById(R.id.count)

        val adapter = CallLogViewPagerAdapter(childFragmentManager, tabLayout!!.getTabCount())
        viewPager!!.adapter = adapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout!!.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
                titleTextView!!.text = titles[tab.position]
                countTextView!!.text = counts[tab.position]
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        titleTextView!!.text = titles[0]
        countTextView!!.text = counts[0]
        return view
    }

    private fun setPage() {
        tabLayout!!.addTab(tabLayout!!.newTab().setText("All Call"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Missed Call"))

        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

    }


    class CallLogViewPagerAdapter(fm: FragmentManager?, var numTabs: Int) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            return when (position) {
                0 -> {
                    var allCallFragments = AllCallFragments()
                    allCallFragments
                }

                1 -> {
                    var missedCallFragment = MissedCallFragment()
                    missedCallFragment
                }
                else -> {
                    null
                }
            }
        }

        override fun getCount(): Int {
            return this!!.numTabs!!
        }


    }
}