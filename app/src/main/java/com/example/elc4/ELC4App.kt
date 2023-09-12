package com.example.elc4

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.elc4.ui.navigation.ELC4NavHost

@Preview
@Composable
fun ELC4App(
    navController: NavHostController = rememberNavController()
) {
    ELC4NavHost(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ELC4TopAppBar(
    canNavigateBack: Boolean,
    navigateBackward: () -> Unit = {}, // est: Go back?
    scrollBehavior: TopAppBarScrollBehavior? = null,
    topBarTitle: String,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton( // est: Back Button, Go back?
                    onClick = navigateBackward
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_action)
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior, // TopAppBarTitle
        title = {Text(topBarTitle)},
        modifier = modifier
    )
}