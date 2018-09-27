package `in`.co.ngcapp.ngc.activity

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.DialPadAdapter
import `in`.co.ngcapp.ngc.adapters.ViewPagerAdapterTwo
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.opengl.Visibility
import android.os.Build
import android.os.Handler
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.view.menu.MenuBuilder
import android.support.v7.view.menu.MenuPopupHelper
import android.support.v7.widget.PopupMenu
import android.view.ContextThemeWrapper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import android.widget.*


class MainHandlingActivity : AppCompatActivity(), View.OnClickListener {

    var mThumbIds = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#")
    var dailpadTexts = arrayOf("ABC", "DEF", "EFG", "IJK", "LMN", "OPQ", "RST", "UVW", "XYZ", "", "+", "")


    var toolbar: Toolbar? = null
    var tabs: TabLayout? = null
    var viewPager: ViewPager? = null
    var adapter: ViewPagerAdapterTwo? = null
    var add_contact: ImageView? = null
    var dial: FloatingActionButton? = null
    var grid_view: GridView? = null
    var dial_pad: LinearLayout? = null
    var isWhite = true
    var my_account: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout_activity)

        tabs = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewPager) as ViewPager
        add_contact = findViewById(R.id.add_contact)
        dial = findViewById(R.id.dial)
        dial_pad = findViewById(R.id.dial_pad)
        grid_view = this.findViewById(R.id.grid_view)
        my_account = findViewById(R.id.my_account)
        dial!!.setOnClickListener(this)
        my_account!!.setOnClickListener(this)
        setPage()
        var dialPadAdapter = DialPadAdapter(this@MainHandlingActivity, mThumbIds, dailpadTexts)
        grid_view!!.adapter = dialPadAdapter
        adapter = ViewPagerAdapterTwo(supportFragmentManager, tabs!!.getTabCount(), this@MainHandlingActivity)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs!!.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
                addTabTint(tab)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                removeTabTint(tab)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        add_contact!!.setOnClickListener(this)
    }


    fun setPage() {
        tabs!!.addTab(tabs!!.newTab().setCustomView(R.layout.tab_map))
        tabs!!.addTab(tabs!!.newTab().setCustomView(R.layout.tab_list))
        tabs!!.tabGravity = TabLayout.GRAVITY_FILL
        addTabTint(tabs!!.getTabAt(0)!!)
    }

    private fun addTabTint(toTab: TabLayout.Tab) {
        val tintColor: Int = resources.getColor(R.color.colorPrimary)
        colorTabView(toTab.customView!!, tintColor)
    }

    private fun removeTabTint(toTab: TabLayout.Tab) {
        val tintColor: Int = resources.getColor(R.color.black)
        colorTabView(toTab.customView!!, tintColor)
    }

    private fun colorTabView(view: View, toColor: Int) {
        view.findViewById<TextView>(R.id.text)
                .setTextColor(toColor)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.findViewById<ImageView>(R.id.icon)
                    .drawable
                    .setTint(toColor)
        }
    }

    //Return current fragment on basis of Position
    fun getFragment(pos: Int): Fragment {
        return adapter?.getItem(pos)!!
    }

    @SuppressLint("RestrictedApi")
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.add_contact -> {
                val wrapper = ContextThemeWrapper(this@MainHandlingActivity, R.style.popupMenuStyle)

                val popup = PopupMenu(wrapper, this!!.add_contact!!)
                popup.inflate(R.menu.add_menu)
                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.add_new -> startActivity(Intent(this@MainHandlingActivity, CreateNewContactActivity::class.java))
                        R.id.new_group -> startActivity(Intent(this@MainHandlingActivity, CreateNewGroupActivity::class.java))


                    }
                    true
                }


                popup.show()
                val menuHelper = MenuPopupHelper(this@MainHandlingActivity, popup.menu as MenuBuilder, v)
                menuHelper.setForceShowIcon(true)
                menuHelper.show()
            }
            R.id.dial -> openDialPad()
            R.id.my_account -> startActivity(Intent(this@MainHandlingActivity, MainMenuActivity::class.java))

        }
    }

    fun openDialPad() {
//        var fragmentManger = supportFragmentManager
//        var dialFragment = DialFragment()
//        dialFragment.show(fragmentManger,"Show")
//        var dialPadAdapter = DialPadAdapter(this@MainHandlingActivity,mThumbIds)
//        grid_view!!.adapter = dialPadAdapter
//        val startRotateAnimation = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
//        dial!!.startAnimation(startRotateAnimation)

        ObjectAnimator.ofFloat(dial, "rotation", 0f, 360f).setDuration(500).start();
        var handler = Handler()
        if (dial_pad!!.visibility == View.GONE)
            slideUp(dial_pad!!)
        else slideDown(dial_pad!!)

        handler.postDelayed({
            if (isWhite) {
                dial!!.setImageDrawable(resources.getDrawable(R.mipmap.call))
                isWhite = false
            } else {
                dial!!.setImageDrawable(resources.getDrawable(R.mipmap.dial_pad_copy_3))
                isWhite = true
            }
        }, 250)

    }


    fun slideUp(view: View) {
        view.visibility = View.VISIBLE
        val animate = TranslateAnimation(0f, 0f, view.height.toFloat(), 0f)
        animate.duration = 300
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    fun slideDown(view: View) {
        val animate = TranslateAnimation(0f, 0f, 0f, view.height.toFloat())
        animate.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                view.visibility = View.GONE
            }
        })
        animate.duration = 300
        animate.fillAfter = true
        view.startAnimation(animate)
    }


}
