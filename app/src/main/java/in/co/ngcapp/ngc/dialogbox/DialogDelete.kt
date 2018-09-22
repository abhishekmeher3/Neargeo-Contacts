package `in`.co.ngcapp.ngc.dialogbox

import `in`.co.ngcapp.ngc.R
import android.app.Dialog
import android.app.DialogFragment
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class  DialogDelete : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var myView = inflater!!.inflate(R.layout.dialog_delete_layout
                , container, false)

        return myView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =  super.onCreateDialog(savedInstanceState)
        dialog.window.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }
}