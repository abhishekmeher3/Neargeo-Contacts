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


class ListFragments : Fragment()  ,AllFriendsFragment.OnFragmentInteractionListener{

    var toolbar: Toolbar? = null
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var fav_contact :TextView?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_tab_layout, container, false)
        toolbar = view.findViewById(R.id.toolbar) as Toolbar

        tabLayout = view.findViewById(R.id.tabs)
        setPage()
        viewPager = view.findViewById(R.id.viewpager) as ViewPager
        fav_contact = view.findViewById(R.id.fav_contact)

        val adapter = ViewPagerAdapter(fragmentManager, tabLayout!!.getTabCount())
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
        return view
    }

   private  fun setPage() {
        tabLayout!!.addTab(tabLayout!!.newTab().setText("All Friend"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Groups"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Favourites"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

    }

    override fun onFragmentInteraction(title: String) {
        fav_contact!!.setText(title)
    }






}
