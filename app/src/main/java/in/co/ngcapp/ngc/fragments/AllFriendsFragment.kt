package `in`.co.ngcapp.ngc.fragments


import `in`.co.ngcapp.ngc.CustomClick.clickAllFriends
import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.activity.TabLayoutActivity
import `in`.co.ngcapp.ngc.adapters.AllFriendsAdapter
import `in`.co.ngcapp.ngc.adapters.AlphabetsAdapter
import `in`.co.ngcapp.ngc.model.AllFriend
import `in`.co.ngcapp.ngc.model.AlphabetsData
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.view.ActionMode
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import `in`.co.ngcapp.ngc.views.Toolbar_ActionMode_Callback
import android.support.v7.app.AppCompatActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AllFriendsFragment : Fragment() {

    var actionMode: ActionMode? = null
    var count = 0
    var all_friends_recycler: RecyclerView? = null
    var alphabets: RecyclerView? = null
    private val mListener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_all_friends, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        all_friends_recycler = view.findViewById<RecyclerView>(R.id.all_friends_recycler)
        alphabets = view.findViewById(R.id.alphabets)
        all_friends_recycler!!.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        alphabets!!.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        if (mListener != null){
            mListener.onFragmentInteraction("276contacts")
        }
        addData()
        getAlphabets()
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


        var adapter = AllFriendsAdapter(this!!.context!!, arrayList, object : clickAllFriends {
            override fun getCount(numbers: Int) {
                Log.i("GetCounts", numbers.toString())
                setOnUiText(numbers)
            }

        })
        all_friends_recycler!!.adapter = adapter
        adapter.notifyDataSetChanged();
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

        var adapter = AlphabetsAdapter(this!!.context!!, alphabets1)
        alphabets!!.adapter = adapter
        adapter.notifyDataSetChanged()


    }

    fun setOnUiText(getNumber: Int) {

        count = getNumber + count //1
        Log.i("Getcount", count.toString())
        if (actionMode == null) {
            actionMode = (activity as AppCompatActivity).startSupportActionMode(Toolbar_ActionMode_Callback(context!!))

        }
        if (actionMode != null) {
            actionMode!!.title = "$count Contacts Selected"

        }
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(title: String)
    }
}