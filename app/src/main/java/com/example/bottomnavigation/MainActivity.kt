package com.example.bottomnavigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navController = rememberNavController()
            var list = listOf<BottomNavItem>(
                BottomNavItem.Home, BottomNavItem.Setting
            )
            BottomNavigationTheme {
                /* Scaffold(bottomBar = { AppBarBottom(navController, list) }) {
                     NavigationGraph(navController)
                 }*/
                /*val showDialog =  remember { mutableStateOf(false) }
                if(showDialog.value)
                    CustomDialog(value = "", setShowDialog = {
                        showDialog.value = it
                    }) {
                        Log.i("HomePage","HomePage : $it")
                    }
                Column() {
                    Button(onClick = {
                        showDialog.value = true
                    }) {
                        Text(text = "Show dialog")
                    }
                }*/
                /*var showDialog = remember { mutableStateOf(false) }
                Column() {
                    if (showDialog.value) {
                        LoadingView()
                    }
                    Button(onClick = { showDialog.value = true }) {

                    }
                }*/
                Column() {
                    MyUI()
                    Row() {
                        val isCheck = remember { mutableStateOf(false) }

                        Card(
                            modifier = Modifier.background(Color.White),
                            elevation = 3.dp,
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.5.dp, color = Color.Green)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(25.dp)
                                    .background(if (isCheck.value) Color.Green else Color.White)
                                    .clickable {
                                        isCheck.value = !isCheck.value
                                    }, contentAlignment = Center
                            ) {
                                if (isCheck.value) Icon(
                                    Icons.Default.Check, contentDescription = "", tint = Color.White
                                )
                            }

                        }
                        Text(
                            modifier = Modifier
                                .align(CenterVertically)
                                .padding(start = 10.dp),
                            text = "I agree with the terms & condition",
                            style = AppObjectTheme.appTypography.largerTitle.copy(fontSize = 30.sp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomNavigationTheme {
        Greeting("Android")
    }
}

@Composable
fun MyUI() {
    val contextForToast = LocalContext.current.applicationContext

    TopAppBar(
        title = {
            Text(text = "Toast")
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(contextForToast, "Back Icon Click", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
            }
        },
        actions = {
            TopAppBarActionButton(
                imageVector = Icons.Outlined.Lock,
                description = "Lock"
            ) {
                Toast.makeText(contextForToast, "Lock Click", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    )
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

@Composable
private fun AppBarBottom(navController: NavHostController, items: List<BottomNavItem>) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screnn ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screnn.screen_route } == true,
                onClick = {
                    navController.navigate(screnn.screen_route) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { screnn.icon },
                label = { Text(text = screnn.title) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabScreen() {
    val pageState = rememberPagerState(pageCount = 3)
}

