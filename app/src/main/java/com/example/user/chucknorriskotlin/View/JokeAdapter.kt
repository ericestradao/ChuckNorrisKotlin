package com.example.user.chucknorriskotlin.View

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.chucknorriskotlin.Model.NeverEndingPojo
import com.example.user.chucknorriskotlin.R
import kotlinx.android.synthetic.main.item_layout.view.*

class JokeAdapter(private val dataList: NeverEndingPojo,
                  private val listener: Context?) :
        RecyclerView.Adapter<JokeAdapter.ViewHolder>(){

//    interface Listener{
//        fun onItemClick(jokes: NeverEndingPojo, position: Int)
//    }
    private val colors : Array<String> = arrayOf("#EF5350", "#EC407A", "#AB47BC", "#7E57C2", "#5C6BC0", "#42A5F5")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList, listener, colors, position)
    }

    override fun getItemCount(): Int = dataList.value.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)

    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bind(jokes: NeverEndingPojo, listener: Context?, colors:
        Array<String>, position: Int){
            itemView.tv_joke.text = jokes.value.get(position).joke
//            itemView.setBackgroundColor(Color.parseColor(colors[position % 6]))
//            itemView.setOnClickListener{
//                listener.onItemClick(jokes, position)
//            }
        }
    }
}