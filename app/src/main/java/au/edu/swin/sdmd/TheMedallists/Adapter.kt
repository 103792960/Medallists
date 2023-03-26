package au.edu.swin.sdmd.TheMedallists

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class Adapter(private val data: List<MedalRecords>, private val listener: (MedalRecords)-> Unit): RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.layout_row, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val data_import = data[position]
        holder.displayRow(data_import)
    }

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val total: TextView = v.findViewById(R.id.totalmedals)
        private val ioccode: TextView = v.findViewById(R.id.ioc)
        private val countryname: TextView = v.findViewById(R.id.country)


        fun displayRow(item: MedalRecords) {
            val totalmedal = item.bronze + item.silver + item.gold
            total.text = totalmedal.toString()
            ioccode.text = item.ioccode
            countryname.text = item.country
            Log.i("countrycode", totalmedal.toString())
            if(totalmedal==0)
            {
                countryname.setTextColor(Color.parseColor("#000000"));

                total.setTextColor(Color.parseColor("#000000"));

                ioccode.setTextColor(Color.parseColor("#000000"));

            }
            else
            {
                countryname.setTextColor(Color.parseColor("#CD7F32"));

                total.setTextColor(Color.parseColor("#CD7F32"));

                ioccode.setTextColor(Color.parseColor("#CD7F32"));
            }
            Log.i("countrycode", item.ioccode)
            if (item.silver<item.gold)
            {
                countryname.setTextColor(Color.parseColor("#FFD700"));

                total.setTextColor(Color.parseColor("#FFD700"));

                ioccode.setTextColor(Color.parseColor("#FFD700"));
            }
            else if (item.bronze<item.silver)
            {
                countryname.setTextColor(Color.parseColor("#808080"));

                total.setTextColor(Color.parseColor("#808080"));

                ioccode.setTextColor(Color.parseColor("#808080"));
            }
            v.setOnClickListener()
            {
                val message = "Gold: ${item.gold}  Silver: ${item.silver}  Bronze: ${item.bronze}"
                val snackbar = Snackbar.make(
                    v,
                    message,
                    Snackbar.LENGTH_SHORT
                )
                snackbar.show()
                listener(item)
            }
        }

    }
}