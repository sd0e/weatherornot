package com.sebdoe.weatherornot

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebdoe.weatherornot.Routes.pages
import com.sebdoe.weatherornot.ui.theme.Alternative1
import com.sebdoe.weatherornot.ui.theme.OnPrimary
import com.sebdoe.weatherornot.ui.theme.Primary

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    val HomePage = NavPage("Home", Icons.Outlined.Home, "home")
    val SettingsPage = NavPage("Settings", Icons.Outlined.Settings, "settings")

    val pages = listOf(HomePage, SettingsPage)
}

@Composable
fun NavBar(selectedRoute: String = Routes.HomePage.route, onChange: (String)->Unit) {
    NavigationBar {
        pages.forEachIndexed { _, item ->
            NavigationBarItem(
                selected = item.route == selectedRoute,
                label = { androidx.compose.material3.Text(text = item.name) },
                icon = { Icon(item.icon, contentDescription = item.name) },
                onClick = { onChange(item.route) }
            )
        }
    }
    /*Row() {
        for (page in Routes.pages) {
            NavBarItem(page = page,
                selected = selectedRoute == page.route,
                modifier = Modifier.clickable {
                    onChange(page.route)
                }.padding(8.dp))
        }
    }*/
}

/*
@Composable
fun NavBarItem(page: NavPage, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Primary else OnPrimary
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) Primary else OnPrimary
        )
    }
}*/
