package `in`.co.ngcapp.ngc.adapters

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.dialogbox.ContactQuickViewDialog
import `in`.co.ngcapp.ngc.model.AllFriend
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.app.Activity


class FavrouiteAdapter(var mContext: Context, var allFriends: ArrayList<AllFriend>) : RecyclerView.Adapter<FavrouiteAdapter.FavrouiteClick>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavrouiteClick {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.group_layout, parent, false)
        return FavrouiteClick(view)
    }

    override fun getItemCount(): Int {

        return allFriends.size
    }

    override fun onBindViewHolder(holder: FavrouiteClick, position: Int) {
        holder.getData(allFriends[position], mContext)
    }

    class FavrouiteClick(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView? = null
        var profession: TextView? = null
        var change_colour: RelativeLayout? = null

        fun getData(allFriend: AllFriend, mContext: Context) {
            name = itemView.findViewById(R.id.name)
            profession = itemView.findViewById(R.id.profession)
            change_colour = itemView.findViewById(R.id.change_colour)
            name!!.text = allFriend.name
            profession!!.text = allFriend.Mprofession
            change_colour!!.setOnClickListener {
                var fragmentManager = (mContext as Activity).fragmentManager
                var contactQuickViewDialog = ContactQuickViewDialog()
                contactQuickViewDialog.show(fragmentManager, "show")
            }
        }

    }


}