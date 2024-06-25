package com.example.tenant

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.adapters.TimeAdapter
import com.google.android.material.tabs.TabLayout
import java.util.Calendar

class PageSeven : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var timeAdapter: TimeAdapter


    val morningStamp: List<String> = listOf("07:00 AM", "08:00 AM", "09:00 AM","10:00 AM", "11:00 AM", "12:00 PM")
    val afternoonStamp: List<String> = listOf("01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM","06:00 PM")
    val eveningStamp: List<String> = listOf("07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM","12:00 AM")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_seven)

        val dateTextview = findViewById<TextView>(R.id.Date_tv)


        dateTextview.setOnClickListener {

            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog =
                DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    dateTextview.text = selectedDate
                }, year, month, day)

            datePickerDialog.show()
        }





        recyclerView = findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = GridLayoutManager(this,3)

        timeAdapter = TimeAdapter(morningStamp)
        recyclerView.adapter = timeAdapter

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> timeAdapter = TimeAdapter(morningStamp)
                    1 -> timeAdapter = TimeAdapter(afternoonStamp)
                    2 -> timeAdapter = TimeAdapter(eveningStamp)
                }
                recyclerView.adapter = timeAdapter
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        tabLayout.addTab(tabLayout.newTab().setText("Morning"))
        tabLayout.addTab(tabLayout.newTab().setText("Afternoon"))
        tabLayout.addTab(tabLayout.newTab().setText("Evening"))


    }
}