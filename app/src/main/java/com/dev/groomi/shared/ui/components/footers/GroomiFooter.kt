package com.dev.groomi.shared.ui.components.footers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddTask
import androidx.compose.material.icons.outlined.AssignmentTurnedIn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GroomiFooter(
    onTodayScheduleClick: () -> Unit,
    onCloseAndDebriefClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        OutlinedButton(
            onClick = onTodayScheduleClick,
            modifier = Modifier.weight(1f)
        ) {
            Icon( imageVector = Icons.Outlined.AddTask, contentDescription = null )
            Spacer(modifier=Modifier.width(8.dp))
            Text("Add Appointment")
        }

        Button(
            onClick = onCloseAndDebriefClick,
            modifier = Modifier.weight(1f)
        ) {
            Icon( imageVector = Icons.Outlined.AssignmentTurnedIn, contentDescription = null )
            Spacer(modifier=Modifier.width(8.dp))
            Text("Close & Debrief")
        }
    }
}
