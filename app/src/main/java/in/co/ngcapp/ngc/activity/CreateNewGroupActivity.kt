package `in`.co.ngcapp.ngc.activity

import `in`.co.ngcapp.ngc.CustomClick.clickAllFriends
import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.AllFriendsAdapter
import `in`.co.ngcapp.ngc.adapters.AlphabetsAdapter
import `in`.co.ngcapp.ngc.adapters.CreateNewGroupAdapter
import `in`.co.ngcapp.ngc.model.AllFriend
import `in`.co.ngcapp.ngc.model.AlphabetsData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout

class CreateNewGroupActivity : AppCompatActivity() {

    var alphabets: RecyclerView? = null
    var fav_recycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_group)

        alphabets = findViewById(R.id.alphabets)
        fav_recycler = findViewById(R.id.fav_recycler)
        alphabets!!.layoutManager = LinearLayoutManager(this@CreateNewGroupActivity, LinearLayout.VERTICAL, false)
        fav_recycler!!.layoutManager = LinearLayoutManager(this@CreateNewGroupActivity, LinearLayout.VERTICAL, false)

        getAlphabets()
        addData()
    }


    fun getAlphabets() {
        var alphabets1 = ArrayList<AlphabetsData>()
        alphabets1.add(AlphabetsData("A"))
        alphabets1.add(AlphabetsData("B"))
        alphabets1.add(AlphabetsData("C"))
        alphabets1.add(AlphabetsData("D"))
        alphabets1.add(AlphabetsData("E"))
        alphabets1.add(AlphabetsData("F"))
        alphabets1.add(AlphabetsData("G"))
        alphabets1.add(AlphabetsData("H"))
        alphabets1.add(AlphabetsData("I"))
        alphabets1.add(AlphabetsData("J"))
        alphabets1.add(AlphabetsData("K"))
        alphabets1.add(AlphabetsData("L"))
        alphabets1.add(AlphabetsData("M"))
        alphabets1.add(AlphabetsData("N"))
        alphabets1.add(AlphabetsData("O"))
        alphabets1.add(AlphabetsData("P"))
        alphabets1.add(AlphabetsData("Q"))
        alphabets1.add(AlphabetsData("R"))
        alphabets1.add(AlphabetsData("S"))
        alphabets1.add(AlphabetsData("T"))
        alphabets1.add(AlphabetsData("U"))
        alphabets1.add(AlphabetsData("V"))
        alphabets1.add(AlphabetsData("W"))
        alphabets1.add(AlphabetsData("X"))
        alphabets1.add(AlphabetsData("Y"))
        alphabets1.add(AlphabetsData("Z"))

        var adapter = AlphabetsAdapter(this@CreateNewGroupActivity, alphabets1)
        alphabets!!.adapter = adapter
        adapter.notifyDataSetChanged()


    }

    fun addData() {
        var arrayList = ArrayList<AllFriend>()

        arrayList.add(AllFriend("Abhishek", "0.5km", "895656656", "Android Developer", 0))
        arrayList.add(AllFriend("Rithik", "0.11km", "5454564654", "Associate Developer", 1))
        arrayList.add(AllFriend("Raj", "0.15km", "1234857869", "Developer", 0))
        arrayList.add(AllFriend("Trinav", "0.25km", "7994561234", "tester", 1))
        arrayList.add(AllFriend("Anil", "0.9km", "895656656", "Admin", 0))
        arrayList.add(AllFriend("Abhishek", "0.5km", "895656656", "Android Developer", 0))
        arrayList.add(AllFriend("Rithik", "0.11km", "5454564654", "Associate Developer", 0))
        arrayList.add(AllFriend("Raj", "0.15km", "1234857869", "Developer", 1))


        var adapter = CreateNewGroupAdapter(this@CreateNewGroupActivity, arrayList, object : clickAllFriends {
            override fun getCount(numbers: Int) {
                Log.i("GetCounts", numbers.toString())
            }

        })
        fav_recycler!!.adapter = adapter
        adapter.notifyDataSetChanged();
    }
}
