package com.dev.groomi.shared.navigation

sealed class Screen(val route: String) {

    object Login : Screen("login")

    object Register : Screen("register")

    object Dashboard : Screen("dashboard")

    object Clients : Screen("clients")

    object ClientDetails : Screen("client/{clientId}")

    object Pets : Screen("pets")

    object PetDetails : Screen("pet/{petId}")

    object Appointments : Screen("appointments")

    object AppointmentDetails : Screen("appointments/{appointmentId}")

    object Expenses : Screen("expenses")

    object Team : Screen("team")

    object Settings : Screen("settings")
}