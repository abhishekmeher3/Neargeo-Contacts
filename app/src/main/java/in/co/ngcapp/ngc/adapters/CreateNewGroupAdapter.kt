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
import android.widget.RadioButton
import android.widget.RelativeLayout
import android.widget.TextView

class CreateNewGroupAdapter(val mContext: Context, var allfriendArrayList: ArrayList<AllFriend>, var clickAllFriends: clickAllFriends) : RecyclerView.Adapter<CreateNewGroupAdapter.AllFriendClick>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllFriendClick {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.createnew_group, parent, false)
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
        var check_user:RelativeLayout?= null
        var radioButton:RadioButton?= null
        fun getData(arrayList: AllFriend, clickAllFriends: clickAllFriends) {
            name = itemView.findViewById(R.id.name)
            profession = itemView.findViewById(R.id.profession)
            phnumber = itemView.findViewById(R.id.phnumber)
            check_user = itemView.findViewById(R.id.check_user)
            radioButton = itemView.findViewById(R.id.checkBox)
            name!!.text = arrayList.name
            profession!!.text = arrayList.Mprofession
            phnumber!!.text = arrayList.mPhoneNumber
            var isChecked = true
            check_user!!.setOnClickListener {

                if (isChecked == true) {
                    radioButton!!.isChecked = true
                    isChecked = false
                }
                else{
                    radioButton!!.isChecked = false
                    isChecked = true

                }


            }


        }

    }


}