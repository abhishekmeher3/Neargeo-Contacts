package `in`.co.ngcapp.ngc.views

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.activity.MainHandlingActivity
import `in`.co.ngcapp.ngc.activity.TabLayoutActivity
import `in`.co.ngcapp.ngc.dialogbox.DialogDelete
import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.support.v4.app.FragmentActivity
import android.support.v4.view.MenuItemCompat
import android.support.v7.view.ActionMode
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class Toolbar_ActionMode_Callback (var mContext:Context) : ActionMode.Callback{






    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.delete ->{
                val transaction = (mContext as FragmentActivity).fragmentManager.beginTransaction()
                var delete = DialogDelete();
                delete.show(transaction,"")
            }
        }
        return false
    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        mode!!.getMenuInflater().inflate(R.menu.bottom_to_chose, menu);//Inflate the menu over action mode
        return true;    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        if (Build.VERSION.SDK_INT < 11) {
            MenuItemCompat.setShowAsAction(menu!!.findItem(R.id.delete_copy), MenuItemCompat.SHOW_AS_ACTION_NEVER);
            MenuItemCompat.setShowAsAction(menu.findItem(R.id.delete), MenuItemCompat.SHOW_AS_ACTION_NEVER);
        } else {
            menu!!.findItem(R.id.delete_copy).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
            menu!!.findItem(R.id.delete).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        }

        return true;    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        //CHANGED

        //val listFragment = TabLayoutActivity().getFragment(0)
        //Log.i("ListFragment", listFragment.toString())
    }


}