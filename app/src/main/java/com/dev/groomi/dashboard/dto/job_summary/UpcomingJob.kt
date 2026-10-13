package com.dev.groomi.dashboard.dto.job_summary

import androidx.annotation.DrawableRes

data class UpcomingJob(
    val appointmentId: String,
    @DrawableRes val imageResId: Int,
    val petId: String,
    val petName: String,
    val petImageUrl: String?,
    val appointmentTime: String,
    val serviceName: String,
    val description: String
)
