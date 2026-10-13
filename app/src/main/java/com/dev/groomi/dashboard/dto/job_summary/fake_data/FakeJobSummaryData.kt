package com.dev.groomi.dashboard.dto.job_summary.fake_data

import com.dev.groomi.dashboard.dto.job_summary.UpcomingJob
import com.dev.groomi.R

public val fakeUpcomingJobs = listOf(
    UpcomingJob(
        appointmentId = "appt-001",
        imageResId = R.drawable.job1,
        petId = "pet-001",
        petName = "Bailey",
        petImageUrl = null,
        appointmentTime = "9:30 AM",
        serviceName = "Full Groom",
        description = "Bath, haircut, nail trim, and ear cleaning."
    ),
    UpcomingJob(
        appointmentId = "appt-002",
        imageResId = R.drawable.job2,
        petId = "pet-002",
        petName = "Luna",
        petImageUrl = null,
        appointmentTime = "11:00 AM",
        serviceName = "Bath & Brush",
        description = "Gentle bath, coat brushing, and nail trim."
    ),
    UpcomingJob(
        appointmentId = "appt-003",
        imageResId = R.drawable.job3,
        petId = "pet-003",
        petName = "Charlie",
        petImageUrl = null,
        appointmentTime = "1:30 PM",
        serviceName = "Puppy Groom",
        description = "First grooming visit with a gentle introduction."
    ),
    UpcomingJob(
        appointmentId = "appt-004",
        imageResId = R.drawable.job4,
        petId = "pet-004",
        petName = "Pepper",
        petImageUrl = null,
        appointmentTime = "3:00 PM",
        serviceName = "Breed-Specific Trim",
        description = "Trim, facial shaping, and paw cleanup."
    )
)
