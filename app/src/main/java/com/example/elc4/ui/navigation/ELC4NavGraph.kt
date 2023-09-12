package com.example.elc4.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elc4.ui.screen.BranchCircuitCreateScreen
import com.example.elc4.ui.screen.BranchCircuitCreateScreenDestination
import com.example.elc4.ui.screen.BranchCircuitDetailScreen
import com.example.elc4.ui.screen.BranchCircuitDetailScreenDestination
import com.example.elc4.ui.screen.CreationSelectionScreen
import com.example.elc4.ui.screen.CreationSelectionScreenDestination
import com.example.elc4.ui.screen.FeederCreateScreen
import com.example.elc4.ui.screen.FeederCreateScreenDestination
import com.example.elc4.ui.screen.MainPanelScreen
import com.example.elc4.ui.screen.MainPanelScreenDestination
import com.example.elc4.ui.screen.ProjectCreateScreen
import com.example.elc4.ui.screen.ProjectCreateScreenDestination
import com.example.elc4.ui.screen.ProjectListScreenDestination
import com.example.elc4.ui.screen.ProjectListScreen
import com.example.elc4.ui.screen.SubFeederCreateScreen
import com.example.elc4.ui.screen.SubFeederCreateScreenDestination

@Composable
fun ELC4NavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ProjectListScreenDestination.route,
        modifier = modifier
    ) {
        composable(route = ProjectListScreenDestination.route) {
            ProjectListScreen(
                navigateToProjectCreateScreen = {navController.navigate(ProjectCreateScreenDestination.route)},
                navigateToMainPanelScreen = {navController.navigate(MainPanelScreenDestination.route)}
            )
        }
        composable(route = ProjectCreateScreenDestination.route) {
            ProjectCreateScreen(
                onNavigateBackward = {navController.navigateUp()} // Go Backward, 1 screen.
            )
        }
        composable(route = MainPanelScreenDestination.route) {
            MainPanelScreen(
                onNavigateBackward = {navController.navigateUp()}, // Go Backward, 1 screen.
                navigateToCreationSelectionScreen = {navController.navigate(CreationSelectionScreenDestination.route)},
                navigateToBranchCircuitDetailScreen = {navController.navigate(BranchCircuitDetailScreenDestination.route)}
            )
        }
        composable(route = CreationSelectionScreenDestination.route) {
            CreationSelectionScreen(
                onNavigateBackward = {navController.navigateUp()},
                navigateToBranchCircuitCreateScreen = {navController.navigate(BranchCircuitCreateScreenDestination.route)},
                navigateToSubFeederCreateScreen = {navController.navigate(SubFeederCreateScreenDestination.route)},
                navigateToFeederCreateScreen = {navController.navigate(FeederCreateScreenDestination.route)}
            )
        }
        composable(route = BranchCircuitCreateScreenDestination.route) {
            BranchCircuitCreateScreen(
                onNavigateBackward = {navController.navigateUp()}
            )
        }
        composable(route = BranchCircuitDetailScreenDestination.route) {
            BranchCircuitDetailScreen(
                onNavigateBackward = {navController.navigateUp()}
            )
        }
        composable(route = SubFeederCreateScreenDestination.route) {
            SubFeederCreateScreen(
                onNavigateBackward = {navController.navigateUp()}
            )
        }
        composable(route = FeederCreateScreenDestination.route) {
            FeederCreateScreen(
                onNavigateBackward = {navController.navigateUp()}
            )
        }
    }
}