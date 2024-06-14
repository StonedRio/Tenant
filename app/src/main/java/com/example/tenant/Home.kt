package com.example.tenant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.tenant.adapters.ViewPagerAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

private lateinit var viewPager: ViewPager2
private lateinit var toggleGroup: MaterialButtonToggleGroup

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        viewPager = findViewById(R.id.view_pager)
        toggleGroup = findViewById(R.id.btn_segmented)

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        toggleGroup.check(R.id.btn_post_new_job)

        toggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                val position = when (checkedId) {
                    R.id.btn_post_new_job -> 0
                    R.id.btn_inprogress -> 1
                    R.id.btn_completed -> 2
                    else -> 0
                }
                viewPager.currentItem = position

                uncheckOtherButtons(group,checkedId)
                updateButtonStyles(toggleGroup)
            }
        }


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

                when (position) {
                    0 -> toggleGroup.check(R.id.btn_post_new_job)
                    1 -> toggleGroup.check(R.id.btn_inprogress)
                    2 -> toggleGroup.check(R.id.btn_completed)
                }
                updateButtonStyles(toggleGroup)
            }
        })
        updateButtonStyles(toggleGroup)
    }

    private fun updateButtonStyles(group: MaterialButtonToggleGroup) {
        for (i in 0 until group.childCount) {
            val button = group.getChildAt(i) as MaterialButton
            if (button.isChecked) {
                button.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                button.setTextColor(ContextCompat.getColor(this, R.color.white))
            } else {
                button.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                button.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }
    }


    private fun uncheckOtherButtons(group: MaterialButtonToggleGroup, checkedId: Int) {
        for (i in 0 until group.childCount) {
            val button = group.getChildAt(i) as MaterialButton
            if (button.id != checkedId) {
                button.isChecked = false
            }
        }
    }


}


