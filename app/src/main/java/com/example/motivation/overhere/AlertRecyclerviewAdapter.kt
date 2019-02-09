import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.motivation.overhere.Alert
import com.example.motivation.overhere.Curation
import com.example.motivation.overhere.R

class AlertRecyclerviewAdapter(list: ArrayList<Alert>) : RecyclerView.Adapter<CustomViewHolder>() {

    var alertList: ArrayList<Alert> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_alertview, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int = alertList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.imageView.setImageResource(alertList[position].img)
        holder.titleTextView.text = alertList[position].text
        holder.timeTextView.text = alertList[position].date
    }
}

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    val imageView = v.findViewById(R.id.alert_img) as ImageView
    val titleTextView = v.findViewById(R.id.alert_text) as TextView
    val timeTextView = v.findViewById(R.id.alert_date) as TextView
}