package me.fabiansuarez.compose.lab.netflixbasicnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.HomeScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.LoginScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterStep2Screen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterStep3Screen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.theme.NetflixBasicNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "login",
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = "login") {
                    LoginScreen(
                        onClickInicioSesion = {
                            navController.navigate(("home"))
                        },
                        onClickRegister = {
                            navController.navigate(("register"))
                        }
                    )
                }
                composable(route = "register") {
                    RegisterScreen(
                        onClickSiguiente = {
                            navController.navigate(("register_step2"))
                        },
                        onClickBack = {
                            navController.popBackStack()
                        }
                    )
                }
                composable(route = "register_step2") {
                    RegisterStep2Screen(onClickSiguiente2 = {
                        navController.navigate(("register_step3"))
                    }, onBackClick = { navController.popBackStack() }
                    )
                }
                composable(route = "register_step3") {
                    RegisterStep3Screen(
                        onClickiniciosesion = {
                            navController.navigate(("home"))
                        },
                        onClickBack = { navController.popBackStack() }
                    )
                }
                composable(route = "home") {
                    HomeScreen()
                }
            }
        }
    }
}