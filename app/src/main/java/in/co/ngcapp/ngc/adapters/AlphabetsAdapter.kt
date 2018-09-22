package `in`.co.ngcapp.ngc.adapters

import `in`.co.ngcapp.ngc.R
import `in`.co.ngcapp.ngc.adapters.AlphabetsAdapter.AlphabetClick
import `in`.co.ngcapp.ngc.model.AllFriend
import `in`.co.ngcapp.ngc.model.AlphabetsData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AlphabetsAdapter(mContext: Context, var alphabets: ArrayList<AlphabetsData>) : RecyclerView.Adapter<AlphabetClick>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetClick {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.alphabets_list, parent, false)
        return AlphabetClick(view)
    }

    override fun getItemCount(): Int {
        return alphabets.size
    }

    override fun onBindViewHolder(holder: AlphabetClick, position: Int) {

        holder.getData(alphabets[position])

    }

    class AlphabetClick(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text_alphabets: TextView? = null

        fun getData(arrayList: AlphabetsData) {
            text_alphabets = itemView.findViewById(R.id.text_alphabets)
            text_alphabets!!.text = arrayList.name

        }
    }

}