package `in`.co.ngcapp.ngc.adapters

import `in`.co.ngcapp.ngc.fragments.*
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log


class ViewPagerAdapterTwo (fm: FragmentManager?, var numTabs :Int ,var mContext:Context) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                var mapFragments = MapFragment()
                Log.v("GetTabs", position.toString())
                return mapFragments
            }
            1 -> {
                var listFragments = ListFragments()
                Log.v("GetTabs", position.toString())

                return listFragments
            }
            else -> {
                return null
            }
        }
    }

    override fun getCount(): Int {
        return this!!.numTabs!!
    }
}