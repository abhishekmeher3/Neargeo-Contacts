package `in`.co.ngcapp.ngc.fragments


import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.utils.Utils
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.os.Build
import android.view.WindowManager
import android.widget.PopupWindow



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MapFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_map, container, false)
        val filterBtn = view.findViewById<ImageView>(R.id.filter)
        filterBtn.setOnClickListener {
            Log.e("hello", "Hello")
            getFilterPopup().showAsDropDown(it)
        }
        return view
    }

//    override fun onResume() {
//        super.onResume()
////        activity?.window?.setSoftInputMode(
////                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
//    }

    fun getFilterPopup(): PopupWindow {

        val popupWindow = PopupWindow(context)
        // inflate your layout or dynamically add view
        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.popup_filter, null)

        popupWindow.isFocusable = true
        popupWindow.width = Utils.dpToPx(280.0f, context)
        popupWindow.height = WindowManager.LayoutParams.WRAP_CONTENT
        popupWindow.contentView = view
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.elevation = 0f
            popupWindow.setBackgroundDrawable(resources.getDrawable(R.drawable.abc_popup_background_mtrl_mult, null))
        }
        popupWindow.isClippingEnabled = true

        return popupWindow
    }
}
