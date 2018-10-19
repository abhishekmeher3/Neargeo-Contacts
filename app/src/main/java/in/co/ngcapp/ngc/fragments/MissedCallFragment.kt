package `in`.co.ngcapp.ngc.fragments


import `in`.co.ngcapp.ngc.CustomClick.clickAllFriends
import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.AllFriendsAdapter
import `in`.co.ngcapp.ngc.adapters.AlphabetsAdapter
import `in`.co.ngcapp.ngc.adapters.MissedCallAdapter
import `in`.co.ngcapp.ngc.model.AllFriend
import `in`.co.ngcapp.ngc.model.AlphabetsData
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
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
class MissedCallFragment : Fragment() {


    var alphabets: RecyclerView? = null
    var all_missed_recycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_missed_call, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        all_missed_recycler = view.findViewById(R.id.all_missed_recycler)
        alphabets = view.findViewById(R.id.alphabets)
        all_missed_recycler!!.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        alphabets!!.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        addData()
        getAlphabets()
    }

    fun addData() {
        var arrayList = ArrayList<AllFriend>()

        arrayList.add(AllFriend("Abhishek", "0.5sec", "20/12/2018/  09:25PM", "9861654645", 0))
        arrayList.add(AllFriend("Rithik", "0.11sec", "20/12/2018/  09:25AM", "9861654645", 0))
        arrayList.add(AllFriend("Raj", "0.15sec", "20/12/2018/  09:25AM", "9861654645", 0))
        arrayList.add(AllFriend("Trinav", "0.25sec", "20/12/2018/  09:25PM", "9861654645", 0))
        arrayList.add(AllFriend("Anil", "0.9sec", "20/12/2018/   01:25AM", "9861654645", 0))
        arrayList.add(AllFriend("Abhishek", "0.5sec", "20/12/2018/  09:25AM", "9861654645", 0))
        arrayList.add(AllFriend("Rithik", "0.11sec", "20/12/2018/  09:25AM", "9861654645", 0))
        arrayList.add(AllFriend("Raj", "0.15sec", "20/12/2018/   09:25AM", "9861654645", 0))


        var adapter = MissedCallAdapter(this!!.context!!, arrayList, object : clickAllFriends {
            override fun getCount(numbers: Int) {
                Log.i("GetCounts", numbers.toString())
            }

        })
        all_missed_recycler!!.adapter = adapter
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


}
