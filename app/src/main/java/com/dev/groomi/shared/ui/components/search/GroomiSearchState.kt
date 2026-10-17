package com.dev.groomi.shared.ui.components.search

data class GroomiSearchState( val query: String = "",
                              val results: List<String> = emptyList(),
                              val isExpanded: Boolean = false )