package com.example.tenant.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.databinding.NewJobCardviewBinding
import com.example.tenant.models.Job

class NewJobsAdapter(private val jobList: List<Job>) : RecyclerView.Adapter<NewJobsAdapter.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = NewJobCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        holder.bind(job)
    }

    override fun getItemCount() = jobList.size

    class JobViewHolder(private val binding: NewJobCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(job: Job) {
            binding.jobIdTv.text = job.jobId
            binding.date.text = job.date
            binding.jobTitle.text = job.title
            binding.statusTv.text = job.status
            binding.statusImageView.setImageResource(job.statusImageResId)
        }
    }
}