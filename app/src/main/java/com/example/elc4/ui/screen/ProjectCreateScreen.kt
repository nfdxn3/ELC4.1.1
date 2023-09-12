package com.example.elc4.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.elc4.ELC4TopAppBar
import com.example.elc4.R
import com.example.elc4.ui.navigation.NavigationDestination

object ProjectCreateScreenDestination : NavigationDestination {
    override val route = "create_project"
    override val titleRes = R.string.titleRes_projectCreate
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun ProjectCreateScreen(
    canNavigateBack: Boolean = true,
    onNavigateBackward: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ELC4TopAppBar(
                canNavigateBack = canNavigateBack,
                navigateBackward = onNavigateBackward,
                topBarTitle = stringResource(ProjectCreateScreenDestination.titleRes)
            )
        }
    ) {innerPadding ->
        ProjectCreateBody(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun ProjectCreateBody(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.desc_projectCreate_sample),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    }
}
