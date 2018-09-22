package `in`.co.ngcapp.ngc.activity

import `in`.co.ngcapp.ngc.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.RelativeLayout

class CreateNewContactActivity : AppCompatActivity() {

    var fab_add_call: FloatingActionButton? = null
    var fab_add_email: FloatingActionButton? = null
    var fab_add_address: FloatingActionButton? = null
    var addCallDetails: RelativeLayout? = null
    var fab_add_events: FloatingActionButton? = null
    var add_address: RelativeLayout? = null
    var addEmail: RelativeLayout? = null
    var event_details: RelativeLayout? = null
    var toolbar: Toolbar?= null
    var i = false
    var email = false
    var address = false
    var event = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_contact)
        fab_add_call = findViewById(R.id.fab_add_call)
        addCallDetails = findViewById(R.id.click_add_phone)
        fab_add_email = findViewById(R.id.fab_add_email)
        addEmail = findViewById(R.id.click_add_email)
        toolbar  = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setDisplayShowHomeEnabled(true);
        fab_add_address = findViewById(R.id.fab_add_address)
        fab_add_events = findViewById(R.id.fab_add_events)
        add_address = findViewById(R.id.add_address)
        event_details = findViewById(R.id.event_details)
        fab_add_call!!.setOnClickListener {

            if (i == false) {
                addCallDetails!!.visibility = View.GONE

                i = true
            } else {
                addCallDetails!!.visibility = View.VISIBLE
                i = false
            }


        }

        fab_add_email!!.setOnClickListener {

            if (email == false) {
                addEmail!!.visibility = View.GONE

                email = true
            } else {
                addEmail!!.visibility = View.VISIBLE
                email = false
            }

        }
        fab_add_address!!.setOnClickListener {

            if (address == false) {
                add_address!!.visibility = View.GONE

                address = true
            } else {
                add_address!!.visibility = View.VISIBLE
                address = false
            }


        }
        fab_add_events!!.setOnClickListener {
            if (event == false) {
                event_details!!.visibility = View.GONE

                event = true
            } else {
                event_details!!.visibility = View.VISIBLE
                event = false
            }
        }
    }
}
