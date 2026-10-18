package com.dev.groomi.shared.ui.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.groomi.shared.ui.components.footers.GroomiFooter
import com.dev.groomi.shared.ui.components.background.GroomiScreenBackground
import com.dev.groomi.shared.ui.components.feedback.GroomiSnackbarHost
import com.dev.groomi.shared.ui.components.headers.DashboardHeader
import com.dev.groomi.shared.ui.components.messaging.GroomiChatButton
import com.dev.groomi.shared.ui.components.search.GroomiSearchBar
import com.dev.groomi.ui.theme.Spacing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewDynamicColors

@Composable
fun GroomiScreenAuthenticated(
    snackbarHostState: SnackbarHostState? = null,
    content: @Composable ColumnScope.() -> Unit,
    searchQuery: String,
    searchResults: List<String>,
    onSearchQueryChanged: (String) -> Unit,
    onSearchSubmitted: (String) -> Unit,
    onSearchExpandedChange: (Boolean) -> Unit,
) {

    var isSearchExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    val toggleSearchBar = {
        isSearchExpanded = !isSearchExpanded
    }

    Scaffold(
        topBar = {
            Column {
                DashboardHeader("My Dashboard",
                    "See Today's Itinerary",
                    onSearchClick = toggleSearchBar,
                    isSearchActive = isSearchExpanded)
                if(isSearchExpanded){
                    GroomiSearchBar(
                        query = searchQuery,
                        onQueryChange = onSearchQueryChanged,
                        onSearch = onSearchSubmitted,
                        searchResults = searchResults,
                        expanded = true,
                        onExpandedChange = onSearchExpandedChange,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        },
        snackbarHost = {
            GroomiSnackbarHost(hostState = snackbarHostState)
        },
        bottomBar = {
            if(!isSearchExpanded){
                Surface(
                    modifier = Modifier.navigationBarsPadding()
                ) {
                    GroomiFooter(
                        onTodayScheduleClick = {},
                        onCloseAndDebriefClick = {}
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            GroomiScreenBackground()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Spacing.lg)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                content = content
            )

            GroomiChatButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, bottom = 16.dp)
            )
        }
    }
}