package `in`.co.ngcapp.ngc.dialogbox

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.activity.ContactDetailsActivity
import android.app.DialogFragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout


class ContactQuickViewDialog : DialogFragment(), View.OnClickListener {

    var view_details: RelativeLayout? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var myView = inflater!!.inflate(R.layout.contact_quick_view
                , container, false)

        view_details = myView.findViewById(R.id.view_details)
        view_details!!.setOnClickListener(this)

        return myView
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.view_details -> {
                startActivity(Intent(activity, ContactDetailsActivity::class.java))
                dismiss()
            }
        }
    }

}