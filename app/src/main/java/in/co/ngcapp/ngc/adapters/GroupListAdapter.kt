package `in`.co.ngcapp.ngc.adapters

import `in`.co.ngcapp.ngc.CustomClick.clickAllFriends
import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.model.AllFriend
import `in`.co.ngcapp.ngc.model.GroupData
import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView


class GroupListAdapter(var context: Context, var groupData: ArrayList<AllFriend>) : RecyclerView.Adapter<GroupListAdapter.GroupListClick>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupListAdapter.GroupListClick {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.friends_adapter_layout, parent, false)

        return GroupListClick(view)
    }

    override fun getItemCount(): Int {
       return groupData.size
    }

    override fun onBindViewHolder(holder: GroupListAdapter.GroupListClick, position: Int) {
        holder.holdData(groupData[position])
    }
    class GroupListClick(itemView:View):RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null
        var profession: TextView? = null
        var phnumber: TextView? = null
        var fav: ImageView? = null
        var change_colour: RelativeLayout? = null
        fun holdData(arrayList: AllFriend) {
            name = itemView.findViewById(R.id.name)
            profession = itemView.findViewById(R.id.profession)
            phnumber = itemView.findViewById(R.id.phnumber)
            change_colour = itemView.findViewById(R.id.change_colour)
            name!!.text = arrayList.name
            profession!!.text = arrayList.Mprofession
            phnumber!!.text = arrayList.mPhoneNumber
            fav = itemView.findViewById(R.id.fav)
//            change_colour!!.setOnClickListener {
//
//                fav!!.visibility = View.VISIBLE
//                change_colour!!.setBackgroundColor(Color.parseColor("#0D97003c"))
//
//
//            }

        }
    }

}