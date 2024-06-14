package com.example.tenant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenant.R
import com.example.tenant.adapters.NewJobsAdapter
import com.example.tenant.databinding.FragmentNewJobsBinding
import com.example.tenant.models.Job

class NewJobsFragment : Fragment() {

    private var _binding: FragmentNewJobsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentNewJobsBinding.inflate(inflater,container,false)
        val view=binding.root


        setupRecyclerView()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        val jobList = generateDummyJobs()
        val adapter = NewJobsAdapter(jobList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun generateDummyJobs(): List<Job> {
        return listOf(
            Job("job-054634624", "February 18", "Fan Repair Works at Lounge", "Approval Pending", R.drawable.ic_pending),
            Job("job-054634625", "February 19", "Plumbing Works at Kitchen", "Rejected By Owner", R.drawable.ic_rejected),
            Job("job-054634626", "February 20", "Electrical Works at Office", "Approved by owner", R.drawable.ic_approved)
        )
    }
}