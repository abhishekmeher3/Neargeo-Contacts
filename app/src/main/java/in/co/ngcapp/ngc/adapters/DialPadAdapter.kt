package `in`.co.ngcapp.ngc.adapters

import `in`.co.ngcapp.ngc.R
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.widget.TextView


class DialPadAdapter(var mContext: Context, var mThumbIds: Array<String>, var texts: Array<String>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var grid: View
        val inflater = mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        grid = inflater.inflate(R.layout.dial_adpter, null)
        var number = grid.findViewById<TextView>(R.id.number)

        number.text = mThumbIds[position].toString()
        var text = grid.findViewById<TextView>(R.id.text);
        text.text = texts[position]
        return grid

    }

    override fun getItem(position: Int): Any {
        return mThumbIds[position]

    }

    override fun getItemId(position: Int): Long {
        return 0

    }

    override fun getCount(): Int {
        return mThumbIds.size

    }

}