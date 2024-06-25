package com.example.tenant.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.R

class TimeAdapter(private val timeList: List<String>) : RecyclerView.Adapter<TimeAdapter.TimeViewHolder>() {

    private var selectedPosition = -1

    inner class TimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeTextView: TextView = itemView.findViewById(R.id.time_textview)
        val itemContainer: ConstraintLayout = itemView.findViewById(R.id.constraint_layout)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (selectedPosition != position) {
                    val previousPosition = selectedPosition
                    selectedPosition = position
                    notifyItemChanged(previousPosition)
                    notifyItemChanged(selectedPosition)
                }
            }
        }

        fun bind(position: Int) {
            val time = timeList[position]
            timeTextView.text = time

            if (selectedPosition == position) {
                itemContainer.isSelected = true
                timeTextView.setTextColor(Color.WHITE)
            } else {
                itemContainer.isSelected = false
                timeTextView.setTextColor(Color.BLACK)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.time_cardview, parent, false)
        return TimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = timeList.size
}
