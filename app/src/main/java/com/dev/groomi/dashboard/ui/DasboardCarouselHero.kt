
package com.dev.groomi.dashboard.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dev.groomi.R
import com.dev.groomi.ui.theme.Amethyst
import com.dev.groomi.ui.theme.FontSize.Subtitle

private data class CarouselItem(
    val id: Int,
    @DrawableRes val imageResId: Int,
    val contentDescription: String
)

@Composable
fun DashboardCarouselHero() {
    val items = remember {
        listOf(
            CarouselItem(
                0,
                R.drawable.dog1,
                "You have 9 jobs set up for today."
            ),
            CarouselItem(
                1,
                R.drawable.dog2,
                "Business is up 22% from last month."
            ),
            CarouselItem(
                2,
                R.drawable.dog3,
                "Revenue is up 13% from last month."
            )
        )
    }

    val pagerState = rememberPagerState(
        pageCount = { items.size }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                horizontal = 24.dp
            ),
            pageSpacing = 16.dp
        ) { page ->
            val item = items[page]

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(item.imageResId),
                    contentDescription = item.contentDescription,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .size(160.dp)
                        .fillMaxWidth()
                        .shadow(
                            elevation = 6.dp,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = item.contentDescription,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = Subtitle,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(items.size) { index ->
                Box(
                    modifier = Modifier
                        .size(
                            width = if (pagerState.currentPage == index) 20.dp else 8.dp,
                            height = 8.dp
                        )
                        .clip(CircleShape)
                        .background(
                            if (pagerState.currentPage == index) {
                                Amethyst
                            } else {
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.25f)
                            }
                        )
                )
            }
        }
    }
}
