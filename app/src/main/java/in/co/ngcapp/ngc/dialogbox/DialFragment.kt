package `in`.co.ngcapp.ngc.dialogbox

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.DialPadAdapter
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView

class DialFragment : DialogFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var myView = inflater!!.inflate(R.layout.dial_layout, container, false)

        var grid_view = myView.findViewById<GridView>(R.id.grid_view)


        return myView
    }
}