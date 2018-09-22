package `in`.co.ngcapp.ngc.fragments


import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.GroupAdapter
import `in`.co.ngcapp.ngc.model.AllFriend
import `in`.co.ngcapp.ngc.model.GroupData
import `in`.co.ngcapp.ngc.views.Toolbar_ActionMode_Callback
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.ActionMode
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout



/**
 * A simple [Fragment] subclass.
 *
 */
class GroupFragment : Fragment() {
    var all_groups_recycler: RecyclerView? = null
    var actionMode: ActionMode? = null
    private val mListener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_group, container, false)
        all_groups_recycler = view.findViewById(R.id.all_groups_recycler)
        all_groups_recycler!!.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (mListener != null){
            mListener.onFragmentInteraction("Group")
        }
        actionMode = null
        getGroupData()
    }

    fun getGroupData() {
        var groupData = ArrayList<GroupData>()
        groupData.add(GroupData("School Friends", "10 members"))
        groupData.add(GroupData("Founder’s Group", "199 members"))
        groupData.add(GroupData("AP PCB", "152 members"))
        groupData.add(GroupData("Music Group", "125 members"))
        groupData.add(GroupData("Family Group", "12 members"))
        groupData.add(GroupData("Family Group", "12 members"))

        var adapter = GroupAdapter(this!!.context!!, groupData)
        all_groups_recycler!!.adapter = adapter
        adapter.notifyDataSetChanged()

    }
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(title: String)
    }



}
