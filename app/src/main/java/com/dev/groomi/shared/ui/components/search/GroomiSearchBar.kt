package com.dev.groomi.shared.ui.components.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import com.dev.groomi.shared.ui.components.background.GroomiVideoBackground
import com.dev.groomi.ui.theme.CarbonBlack
import com.dev.groomi.ui.theme.LavenderGrey
import com.dev.groomi.ui.theme.RoyalOrchid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroomiSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .semantics { isTraversalGroup = true }
    ) {
        GroomiVideoBackground()
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = 0f },
            colors = SearchBarDefaults.colors(
                containerColor = Color.Transparent,
            ),
            inputField = {
                SearchBarDefaults.InputField(
                    query = query,
                    onQueryChange = onQueryChange,
                    onSearch = {
                        onSearch(query)
                        onExpandedChange(false)
                    },
                    expanded = expanded,
                    onExpandedChange = onExpandedChange,
                    placeholder = { Text("Search Groomi...") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search"
                        )
                    },
                    colors = SearchBarDefaults.inputFieldColors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    )
                )
            },
            expanded = expanded,
            onExpandedChange = onExpandedChange
        ) {
            Column(
                Modifier.verticalScroll(rememberScrollState())
            ) {
                searchResults.forEach { result ->
                    ListItem(
                        headlineContent = { Text(result) },
                        colors = ListItemDefaults.colors(
                            containerColor = Color.Transparent,
                            headlineColor = Color(0xFF292633)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onQueryChange(result)
                                onExpandedChange(false)
                            }
                    )
                }
            }
        }
    }
}