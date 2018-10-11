package `in`.co.ngcapp.ngc.fragments


import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.ViewPagerAdapter
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

//the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ListFragments : Fragment(), AllFriendsFragment.OnFragmentInteractionListener {

    var toolbar: Toolbar? = null
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var fav_contact: TextView? = null
    var titleTextView: TextView? = null
    var countTextView: TextView? = null

    var titles = arrayOf("Your Contacts", "Your groups", "Your favorites" ,"Your Miss call","Your All contact")
    var counts = arrayOf("265 total contacts", "26 total groups", "5 favorite contacts","10 miss call","320 contacts")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_tab_layout, container, false)
        toolbar = view.findViewById(R.id.toolbar) as Toolbar

        tabLayout = view.findViewById(R.id.tabs)
        setPage()
        viewPager = view.findViewById(R.id.viewpager) as ViewPager
        titleTextView = view.findViewById(R.id.title)
        countTextView = view.findViewById(R.id.count)

        val adapter = ViewPagerAdapter(fragmentManager, tabLayout!!.getTabCount())
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
        tabLayout!!.addTab(tabLayout!!.newTab().setText("All Friend"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Groups"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Favourites"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Missed Call"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("All Call"))


        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

    }

    override fun onFragmentInteraction(title: String) {
    }


}
