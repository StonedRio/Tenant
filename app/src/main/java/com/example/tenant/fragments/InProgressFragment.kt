package com.example.tenant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenant.adapters.InProgressJobsAdapter
import com.example.tenant.databinding.FragmentInProgressBinding
import com.example.tenant.models.InProgressJob

class InProgressFragment : Fragment() {
    private var _binding: FragmentInProgressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentInProgressBinding.inflate(inflater,container,false)
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
        val adapter = InProgressJobsAdapter(jobList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun generateDummyJobs(): List<InProgressJob> {
        return listOf(
            InProgressJob("job-054634624", "February 18", "Fan Repair Works at Lounge"),
            InProgressJob("job-054634625", "February 19", "Plumbing Works at Kitchen"),
            InProgressJob("job-054634626", "February 20", "Electrical Works at Office")
        )
    }

}