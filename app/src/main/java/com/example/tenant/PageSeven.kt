package com.example.tenant

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Calendar

class PageSeven : AppCompatActivity() {

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
                    // Setting the date on the TextView
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    dateTextview.text = selectedDate
                }, year, month, day)

            datePickerDialog.show()
        }

    }
}