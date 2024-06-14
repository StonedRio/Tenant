package com.example.tenant.models

data class Job(
    val jobId: String,
    val date: String,
    val title: String,
    val status: String,
    val statusImageResId: Int
)
