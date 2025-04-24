package com.example.fitnesstracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.R
import com.example.fitnesstracker.models.Session

// Adapter to bind session data to RecyclerView using ListAdapter and DiffUtil
class SessionAdapter : ListAdapter<Session, SessionAdapter.SessionViewHolder>(DiffCallback()) {

    // ViewHolder holds the views for each item in the RecyclerView
    class SessionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textDate: TextView = itemView.findViewById(R.id.textDate)
        private val textWorkout: TextView = itemView.findViewById(R.id.textWorkout)
        private val textDuration: TextView = itemView.findViewById(R.id.textDuration)

        fun bind(session: Session) {
            textDate.text = session.date
            textWorkout.text = session.workoutType
            textDuration.text = session.duration
        }
    }

    // Inflate layout for item view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_session, parent, false)
        return SessionViewHolder(view)
    }

    // Bind session data to view
    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // DiffUtil helps efficiently update only changed items
    class DiffCallback : DiffUtil.ItemCallback<Session>() {
        override fun areItemsTheSame(oldItem: Session, newItem: Session): Boolean {
            return oldItem.date == newItem.date && oldItem.workoutType == newItem.workoutType
        }

        override fun areContentsTheSame(oldItem: Session, newItem: Session): Boolean {
            return oldItem == newItem
        }
    }
}

//https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter
//https://developer.android.com/reference/androidx/recyclerview/widget/DiffUtil