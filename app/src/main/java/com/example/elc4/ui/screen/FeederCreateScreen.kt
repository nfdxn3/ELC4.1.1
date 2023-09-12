package com.example.elc4.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.elc4.ELC4TopAppBar
import com.example.elc4.R
import com.example.elc4.ui.navigation.NavigationDestination

object FeederCreateScreenDestination : NavigationDestination {
    override val route = "create_Feeder"
    override val titleRes = R.string.titleRes_FeederCreate
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeederCreateScreen(
    canNavigateBack: Boolean = true,
    onNavigateBackward: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ELC4TopAppBar(
                canNavigateBack = canNavigateBack,
                navigateBackward = onNavigateBackward,
                topBarTitle = stringResource(FeederCreateScreenDestination.titleRes)
            )
        }
    ) { innerPadding ->
        FeederCreateBody(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun FeederCreateBody(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.desc_FeederCreate_sample),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    }
}