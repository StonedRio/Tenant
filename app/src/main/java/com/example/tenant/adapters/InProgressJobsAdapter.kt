package com.example.tenant.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.databinding.InProgressJobCardviewBinding
import com.example.tenant.models.InProgressJob

class InProgressJobsAdapter(private val jobList: List<InProgressJob>) : RecyclerView.Adapter<InProgressJobsAdapter.inProgressJobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): inProgressJobViewHolder {
        val binding = InProgressJobCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return inProgressJobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: inProgressJobViewHolder, position: Int) {
        val job = jobList[position]
        holder.bind(job)
    }

    override fun getItemCount() = jobList.size

    class inProgressJobViewHolder(private val binding: InProgressJobCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(job: InProgressJob) {
            binding.jobIdTv.text = job.jobId
            binding.date.text = job.date
            binding.jobTitle.text = job.title
        }
    }
}