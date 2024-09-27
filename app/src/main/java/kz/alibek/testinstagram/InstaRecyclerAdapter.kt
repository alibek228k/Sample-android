package kz.alibek.testinstagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class InstaRecyclerAdapter(
    private val dataItems: List<InstaData>
): Adapter<InstaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstaViewHolder {
        return InstaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.insta_recycler_item, parent, false)
        )
    }

    override fun getItemCount(): Int = dataItems.size

    override fun onBindViewHolder(holder: InstaViewHolder, position: Int) {
        holder.bind(dataItems[position])
    }
}

class InstaViewHolder(itemView: View): ViewHolder(itemView) {

    private val textView: TextView by lazy { itemView.findViewById(R.id.insta_item_title) }
    private val imageView: ImageView by lazy { itemView.findViewById(R.id.insta_item_icon) }

    fun bind(dataItem: InstaData) {
        textView.text = dataItem.title
        imageView.setImageResource(dataItem.iconRes)
    }
}

data class InstaData(
    val title: String,
    @DrawableRes val iconRes: Int,
)