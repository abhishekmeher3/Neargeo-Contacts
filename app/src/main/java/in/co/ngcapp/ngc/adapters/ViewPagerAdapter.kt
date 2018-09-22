package `in`.co.ngcapp.ngc.adapters

import `in`.co.ngcapp.ngc.fragments.AllFriendsFragment
import `in`.co.ngcapp.ngc.fragments.FavrouiteFragment
import `in`.co.ngcapp.ngc.fragments.GroupFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import kotlin.math.log

class ViewPagerAdapter(fm: FragmentManager? ,var numTabs :Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int) : Fragment? {

        when (position) {
            0 -> {
                var allFriends = AllFriendsFragment()
                Log.v("GetTabs",position.toString())
                return allFriends
            }
            1 -> {
                var groups = GroupFragment()
                Log.v("GetTabs",position.toString())

                return groups
            }
            2 -> {
                var fravouiteFragment = FavrouiteFragment()
                Log.v("GetTabs",position.toString())
                return fravouiteFragment
            }
            else  -> {
                return null
            }
        }
    }

    override fun getCount(): Int {
        return this!!.numTabs!!
    }


}