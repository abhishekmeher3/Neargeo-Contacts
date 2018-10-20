package `in`.co.ngcapp.ngc.adapters

import `in`.co.ngcapp.ngc.CustomClick.clickAllFriends
import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.model.AllFriend
import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView


class AllContactAdapter(val mContext: Context, var allfriendArrayList: ArrayList<AllFriend>, var clickAllFriends: clickAllFriends) : RecyclerView.Adapter<AllContactAdapter.AllFriendClick>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllFriendClick {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.missed_call_logs, parent, false)
        return AllFriendClick(view)
    }

    override fun getItemCount(): Int {

        return allfriendArrayList.size
    }

    override fun onBindViewHolder(holder: AllFriendClick, position: Int) {


        holder.getData(allfriendArrayList[position], clickAllFriends)
    }

    class AllFriendClick(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView? = null
        var profession: TextView? = null
        var phnumber: TextView? = null
        var fav: ImageView? = null
        var day: TextView? = null
        var km_icon: ImageView? = null
        var change_colour: RelativeLayout? = null
        fun getData(arrayList: AllFriend, clickAllFriends: clickAllFriends) {
            name = itemView.findViewById(R.id.name)
            profession = itemView.findViewById(R.id.profession)
            phnumber = itemView.findViewById(R.id.phnumber)
            change_colour = itemView.findViewById(R.id.change_colour)
            day = itemView.findViewById(R.id.day)
            km_icon = itemView.findViewById(R.id.km_icon)
            name!!.text = arrayList.name
            profession!!.text = arrayList.Mprofession
            phnumber!!.text = arrayList.mPhoneNumber
            day!!.text = arrayList.address
            fav = itemView.findViewById(R.id.fav)
            change_colour!!.setOnClickListener {

                //fav!!.visibility = View.VISIBLE
                change_colour!!.setBackgroundColor(Color.parseColor("#0D97003c"))

                var i = 1
                clickAllFriends.getCount(i)

            }
            if (arrayList.mFav == 1) {
//                fav!!.visibility = View.VISIBLE


                phnumber!!.setTextColor(Color.parseColor("#97003c"))
                day!!.setTextColor(Color.parseColor("#97003c"))
                name!!.setTextColor(Color.parseColor("#97003c"))
                profession!!.setTextColor(Color.parseColor("#97003c"))
                km_icon!!.setImageResource(R.drawable.ic_info_outline_black_24dp)

//                change_colour!!.setBackgroundColor(Color.parseColor("#0D97003c"))
            } else {
//                fav!!.visibility = View.GONE
//                change_colour!!.setBackgroundColor(Color.parseColor("#ffffff"))
                phnumber!!.setTextColor(Color.parseColor("#3a3b3c"))
                day!!.setTextColor(Color.parseColor("#3a3b3c"))
                name!!.setTextColor(Color.parseColor("#3a3b3c"))
                profession!!.setTextColor(Color.parseColor("#3a3b3c"))
                km_icon!!.setImageResource(R.drawable.ic_info_outline_24dp)

            }
        }

    }


}