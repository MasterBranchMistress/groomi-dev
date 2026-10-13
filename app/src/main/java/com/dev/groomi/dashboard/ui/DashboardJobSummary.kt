package com.dev.groomi.dashboard.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.groomi.dashboard.dto.job_summary.UpcomingJob


@Composable
fun DashboardJobSummary(
    jobs: List<UpcomingJob>,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        pageCount = { jobs.size }
    )

    if (jobs.isEmpty()) {
        Text(
            text = "No upcoming appointments",
            modifier = modifier.padding(16.dp)
        )
        return
    }

    VerticalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .height(420.dp),
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(vertical = 8.dp)
    ) { page ->
        val job = jobs[page]

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(24.dp))
        ) {
            Image(
                painter = painterResource(job.imageResId),
                contentDescription = "Photo of ${job.petName}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.surface.copy(
                            alpha = 0.88f
                        )
                    )
                    .padding(20.dp)
            ) {
                Text(
                    text = job.petName,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "${job.appointmentTime} · ${job.serviceName}",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = job.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
