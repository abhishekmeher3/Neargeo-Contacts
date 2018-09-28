package `in`.co.ngcapp.ngc.activity

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.GroupListAdapter
import `in`.co.ngcapp.ngc.model.AllFriend
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.view.MenuInflater
import android.view.ContextMenu.ContextMenuInfo
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast


class GroupDetailsActivity : AppCompatActivity() {
    var groups_details_recycler: RecyclerView? = null
    var toolbar: Toolbar? = null
    var context_menu: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_details)
        groups_details_recycler = findViewById(R.id.groups_details_recycler)
        toolbar = findViewById(R.id.toolbar)
        context_menu = findViewById(R.id.context_menu)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        groups_details_recycler!!.layoutManager = LinearLayoutManager(this@GroupDetailsActivity, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
        registerForContextMenu(context_menu)

        context_menu!!.setOnClickListener {
            callPopUpmenu(context_menu!!)
        }
        addData()
    }


    fun addData() {
        var arrayList = ArrayList<AllFriend>()

        arrayList.add(AllFriend("Abhishek", "0.5km", "895656656", "Android Developer", 0))
        arrayList.add(AllFriend("Rithik", "0.11km", "5454564654", "Assiciate soft Developer", 1))
        arrayList.add(AllFriend("Raj", "0.15km", "1234857869", "Developer", 0))
        arrayList.add(AllFriend("Trinav", "0.25km", "7994561234", "tester", 1))
        arrayList.add(AllFriend("Anil", "0.9km", "895656656", "Admin", 0))
        arrayList.add(AllFriend("Abhishek", "0.5km", "895656656", "Android Developer", 0))
        arrayList.add(AllFriend("Rithik", "0.11km", "5454564654", "Assiciate soft Developer", 0))
        arrayList.add(AllFriend("Raj", "0.15km", "1234857869", "Developer", 1))


        var adapter = GroupListAdapter(this@GroupDetailsActivity, arrayList)
        groups_details_recycler!!.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    fun callPopUpmenu(btn: ImageView) {

        val popup = PopupMenu(this@GroupDetailsActivity, btn)
        //Inflating the Popup using xml file
        popup.menuInflater.inflate(R.menu.schol_friends_menu, popup.getMenu())

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener { item ->
            Toast.makeText(this@GroupDetailsActivity, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show()
            true
        }

        popup.show()//showing popup menu
    }
}
