/*
 * AppNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.hellowordkmp.mobile.presenter.home.view.HomeScreen
import com.hellowordkmp.mobile.presenter.login.LoginScreen
import com.hellowordkmp.mobile.presenter.welcome.WelcomeScreen
import com.hellowordkmp.mobile.theme.AppTheme

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    AppTheme {
        NavHost(
            navController = navController,
            startDestination = WelcomeRoute,
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() },
            popEnterTransition = { popEnterTransition() },
            popExitTransition = { popExitTransition() },
        ) {
            composable<WelcomeRoute> {
                WelcomeScreen(
                    onNavigateToLogin = {
                        navController.navigate(LoginRoute) {
                            popUpTo(WelcomeRoute) { inclusive = true }
                        }
                    },
                )
            }

            composable<LoginRoute> {
                LoginScreen(
                    onLoginSuccess = { username ->
                        navController.navigate(HomeRoute(username = username)) {
                            popUpTo(LoginRoute) { inclusive = true }
                        }
                    },
                )
            }

            composable<HomeRoute> { backStackEntry ->
                val routeData = backStackEntry.toRoute<HomeRoute>()
                HomeScreen(
                    username = routeData.username,
                    onLogout = {
                        navController.navigate(LoginRoute) {
                            popUpTo(HomeRoute(username = routeData.username)) { inclusive = true }
                        }
                    },
                )
            }
        }
    }
}
