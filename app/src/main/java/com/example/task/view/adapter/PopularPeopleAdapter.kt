package com.example.task.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.model.PopularPeopleModel

class PopularPeopleAdapter(var popularPeopleModel: PopularPeopleModel) : RecyclerView.Adapter<PopularPeopleAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_popular_people, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(popularPeopleModel)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return popularPeopleModel.results.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(popularPeopleModel: PopularPeopleModel) {
           // val img = itemView.findViewById(R.id.img) as ImageView
            val tName  = itemView.findViewById(R.id.tName) as TextView
            val tDate  = itemView.findViewById(R.id.tDate) as TextView

          //  img.loadImage(Constants.IMAGE_BASE_URL+referncesModel.refrenceImage)
            tName.text = popularPeopleModel.results.get(position).knownFor[0].originalName
          //  tDate.text = popularPeopleModel.results.get(position).knownFor.get(position).firstAirDate

        }
    }
}