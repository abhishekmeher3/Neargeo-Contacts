package `in`.co.ngcapp.ngc.activity

import `in`.co.ngcapp.ngc.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.Button
import android.widget.TextView
import android.widget.LinearLayout
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.os.Build
import android.view.View


class WalkThroughActivity : AppCompatActivity() {
    var mViewPager:ViewPager ?= null
    private val viewPager: ViewPager? = null
    private val dotsLayout: LinearLayout? = null
    private val dots: Array<TextView>? = null
    private var layouts: IntArray? = null
    private val btnSkip: Button? = null
    val btnNext: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Checking for first time launch - before calling setContentView()
       /// prefManager = PrefManager(this)
//        if (!prefManager.isFirstTimeLaunch()) {
//            launchHomeScreen()
//            finish()
//        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }



        setContentView(R.layout.activity_walk_through)
        mViewPager =  findViewById(R.id.pager)

        layouts = intArrayOf(R.layout.welcome_two, R.layout.welcome_two, R.layout.welcome_two, R.layout.welcome_two)


    }


}


