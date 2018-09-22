package `in`.co.ngcapp.ngc.activity

import `in`.co.ngcapp.ngc.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import android.R.attr.button
import android.view.MenuItem
import android.widget.PopupMenu


class ContactDetailsActivity : AppCompatActivity() {

    var more: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        more = findViewById(R.id.more)
        more!!.setOnClickListener {
            callPopUpmenu(more!!)

        }
    }


    fun callPopUpmenu(btn: ImageView) {

        val popup = PopupMenu(this@ContactDetailsActivity, btn)
        //Inflating the Popup using xml file
        popup.menuInflater.inflate(R.menu.account_menu, popup.getMenu())

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                Toast.makeText(this@ContactDetailsActivity, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show()
                return true
            }
        })

        popup.show()//showing popup menu
    }
}
