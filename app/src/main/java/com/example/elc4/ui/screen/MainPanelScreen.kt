package com.example.elc4.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.elc4.ELC4TopAppBar
import com.example.elc4.R
import com.example.elc4.ui.navigation.NavigationDestination

object MainPanelScreenDestination : NavigationDestination {
    override val route = "mainPanel"
    override val titleRes = R.string.titleRes_mainPanel
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPanelScreen(
    canNavigateBack: Boolean = true,
    navigateToCreationSelectionScreen: () -> Unit,
    navigateToBranchCircuitDetailScreen: () -> Unit,
    onNavigateBackward: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navigateToCreationSelectionScreen()},
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = stringResource(R.string.conDes_mainPanelCreate)
                )
            }
        },
        topBar = {
            ELC4TopAppBar(
                canNavigateBack = canNavigateBack,
                navigateBackward = onNavigateBackward,
                scrollBehavior = scrollBehavior,
                topBarTitle = stringResource(MainPanelScreenDestination.titleRes)
            )
        },
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {innerPadding ->
        MainPanelBody(
            onBranchCircuitClick1 = {navigateToBranchCircuitDetailScreen()},
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun MainPanelBody(
    onBranchCircuitClick1: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        MainPanelItemList(
            onBranchClick0 = {onBranchCircuitClick1()},
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
        )
        /*
        Text(
            text = stringResource(R.string.desc_mainPanel_sample),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        */
    }
}

@Composable
fun MainPanelItemList(
    onBranchClick0: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            MainPanelItem(
                modifier = Modifier
                    .clickable {onBranchClick0()}
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Preview
@Composable
fun MainPanelItem(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement
                    .spacedBy(dimensionResource(R.dimen.padding_small)),
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_large)),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Lighting Outlet",
                        style = MaterialTheme.typography.titleLarge,
                    )
                    Spacer(Modifier.weight(1f))
                    Column {
                        Text(
                            text = "1500 VA",
                            style = MaterialTheme.typography.bodyLarge,
                        )
                        Text(
                            text = "6.522 A",
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
                Text(
                    text = "*Use: 2-3.5 mm2 THWN Cu Wire, in 20mm dia. PVC Conduit",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = "*Use: 1-20 AT, 2P, ACB",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}
