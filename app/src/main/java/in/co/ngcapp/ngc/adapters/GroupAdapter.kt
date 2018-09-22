package `in`.co.ngcapp.ngc.adapters

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.activity.GroupDetailsActivity
import `in`.co.ngcapp.ngc.model.AlphabetsData
import `in`.co.ngcapp.ngc.model.GroupData
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView


class GroupAdapter(var context: Context, var groupData: ArrayList<GroupData>) : RecyclerView.Adapter<GroupAdapter.GroupClick>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupClick {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.all_friend_layout, parent, false)

        return GroupClick(view)
    }

    override fun getItemCount(): Int {
        return groupData.size
    }

    override fun onBindViewHolder(holder: GroupClick, position: Int) {
        holder.holdData(groupData[position], context)
    }

    class GroupClick(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image_view: ImageView? = null
        var name: TextView? = null
        var profession: TextView? = null
        var change_colour: RelativeLayout? = null
        fun holdData(groupData: GroupData, mcontext: Context) {
            name = itemView.findViewById(R.id.name)
            profession = itemView.findViewById(R.id.profession)
            change_colour = itemView.findViewById(R.id.change_colour)
            name!!.text = groupData.mGroupNAme
            profession!!.text = groupData.members
            change_colour!!.setOnClickListener {
                mcontext.startActivity(Intent(mcontext, GroupDetailsActivity::class.java))

            }
        }

    }


}