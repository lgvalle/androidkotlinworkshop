package com.kotlinsevilla.cookietinder.liked

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlinsevilla.cookietinder.Cookie
import com.kotlinsevilla.cookietinder.R


class MyAdapter(private val myDataset: List<Cookie>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        // create a new view
        val viewGroup = LayoutInflater.from(parent.context)
            .inflate(R.layout.liked_cookies_row, parent, false) as ViewGroup
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(viewGroup)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.cookieName.text = myDataset[position].name
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup) {
        val cookieName = viewGroup.findViewById<TextView>(R.id.liked_cookie_name)
    }
}
