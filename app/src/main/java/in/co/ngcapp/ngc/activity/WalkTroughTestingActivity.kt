
package `in`.co.ngcapp.ngc.activity

import `in`.co.ngcapp.ngc.R
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.view.ViewGroup
import java.nio.file.Files.size
import android.view.LayoutInflater
import java.util.ArrayList
import android.content.Context
import android.support.v4.view.PagerAdapter
import java.util.TimerTask
import java.util.Timer
import `in`.co.ngcapp.ngc.activity.SlidingImage_Adapter
import `in`.co.ngcapp.ngc.model.SplashData
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.widget.TextView
import com.viewpagerindicator.CirclePageIndicator


class WalkTroughTestingActivity : AppCompatActivity() {


    var pager: ViewPager? = null
    private var currentPage = 0
    private var NUM_PAGES = 0
    private val IMAGES = arrayOf<Int>(R.mipmap.scan_org, R.mipmap.add_org, R.mipmap.connected_org, R.mipmap.print)

    var textname = arrayOf("Scan", "Add", "Connect", "Add")
    var desc: Array<Int> = arrayOf(R.string.print, R.string.scan, R.string.connect, R.string.add)


    var addAll = ArrayList<SplashData>()

    val ImagesArray = ArrayList<Int>()
    var splashData: SplashData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk)

        pager = findViewById(R.id.pager)
        init()

    }

    private fun init() {
        for (i in 0 until IMAGES.size) {
            var getImages = IMAGES[i]
            var getext = textname[i]
            var description = desc[i]
            splashData = SplashData(getext, getImages, description)
            addAll.add(splashData!!)

        }

        pager!!.setAdapter(SlidingImage_Adapter(this@WalkTroughTestingActivity, addAll))


        val indicator = findViewById<View>(R.id.indicator) as CirclePageIndicator

        indicator.setViewPager(pager)

        val density = resources.displayMetrics.density

        //Set circle indicator radius
        indicator.setRadius(5 * density)

//        NUM_PAGES = IMAGES.size
//
//        // Auto start of viewpager
//        val handler = Handler()
//        val Update = Runnable {
//            if (currentPage === NUM_PAGES) {
//                currentPage = 0
//            }
//            pager!!.setCurrentItem(currentPage++, true)
//        }
//        val swipeTimer = Timer()
//        swipeTimer.schedule(object : TimerTask() {
//            override fun run() {
//                handler.post(Update)
//            }
//        }, 3000, 3000)

        // Pager listener over indicator
        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                currentPage = position
                Log.i("Positions", position.toString())
                if (currentPage == 3) {
                    startActivity(Intent(this@WalkTroughTestingActivity, LoginActivity::class.java))
                }

            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {

            }

            override fun onPageScrollStateChanged(pos: Int) {

            }
        })

    }
}

class SlidingImage_Adapter(private val context: Context, private val IMAGES: ArrayList<SplashData>) : PagerAdapter() {
    private val inflater: LayoutInflater


    init {
        inflater = LayoutInflater.from(context)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return IMAGES.size
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.images_holder, view, false)!!

        val imageView = imageLayout!!
                .findViewById(R.id.image) as ImageView
        val print_text = imageLayout.findViewById<TextView>(R.id.print_text)
        val description = imageLayout.findViewById<TextView>(R.id.description)


        imageView.setImageResource(IMAGES[position].images)
        print_text.setText(IMAGES[position].name)
        description.setText(IMAGES[position].descriptions)

        view.addView(imageLayout, 0)

        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }


}
