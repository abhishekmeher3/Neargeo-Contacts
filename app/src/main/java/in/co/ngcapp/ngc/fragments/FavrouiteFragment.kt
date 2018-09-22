package `in`.co.ngcapp.ngc.fragments


import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.AllFriendsAdapter
import `in`.co.ngcapp.ngc.adapters.FavrouiteAdapter
import `in`.co.ngcapp.ngc.model.AllFriend
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FavrouiteFragment : Fragment() {

    var fav_recycler: RecyclerView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_favrouite, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fav_recycler = view.findViewById(R.id.fav_recycler)
        fav_recycler!!.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

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


        var adapter = FavrouiteAdapter(this!!.context!!,arrayList)
        fav_recycler!!.adapter = adapter
    }


}
