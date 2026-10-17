package com.dev.groomi.shared.ui.components.search

object GroomiSearchData {

    private val searchableItems = listOf(
        "Appointments",
        "Customers",
        "Pets",
        "Settings"
    )

    fun search(query: String): List<String> {
        if (query.isBlank()) return emptyList()

        return searchableItems.filter {
            it.contains(query.trim(), ignoreCase = true)
        }
    }
}