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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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

object CreationSelectionScreenDestination : NavigationDestination {
    override val route = "create_selectionPanel"
    override val titleRes = R.string.titleRes_creationSelection
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreationSelectionScreen(
    canNavigateBack: Boolean = true,
    navigateToBranchCircuitCreateScreen: () -> Unit,
    navigateToSubFeederCreateScreen: () -> Unit,
    navigateToFeederCreateScreen: () -> Unit,
    onNavigateBackward: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            ELC4TopAppBar(
                canNavigateBack = canNavigateBack,
                navigateBackward = onNavigateBackward,
                scrollBehavior = scrollBehavior,
                topBarTitle = stringResource(CreationSelectionScreenDestination.titleRes)
            )
        },
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        CreationSelectionBody(
            onBranchCircuitCreateSelect1 = {navigateToBranchCircuitCreateScreen()},
            onSubFeederCreateSelect1 = {navigateToSubFeederCreateScreen()},
            onFeederCreateSelect1 = {navigateToFeederCreateScreen()},
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun CreationSelectionBody(
    onBranchCircuitCreateSelect1: () -> Unit,
    onSubFeederCreateSelect1: () -> Unit,
    onFeederCreateSelect1: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        CreationSelectionList(
            onBranchCircuitCreateSelect0 = onBranchCircuitCreateSelect1,
            onSubFeederCreateSelect0 = onSubFeederCreateSelect1,
            onFeederCreateSelect0 = onFeederCreateSelect1,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
        )
        /*
        Text(
            text = stringResource(R.string.desc_creationSelection_sample),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        */
    }
}

@Composable
fun CreationSelectionList(
    onBranchCircuitCreateSelect0: () -> Unit,
    onSubFeederCreateSelect0: () -> Unit,
    onFeederCreateSelect0: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier
    ) {
        item {
            CreationSelectionItem(
                itemTitle = "Add New Branch Circuit",
                modifier = Modifier
                    .clickable {onBranchCircuitCreateSelect0()}
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
        item {
            CreationSelectionItem(
                itemTitle = "Add New Sub-Feeder",
                modifier = Modifier
                    .clickable {onSubFeederCreateSelect0()}
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
        item {
            CreationSelectionItem(
                itemTitle = "Add New Feeder",
                modifier = Modifier
                    .clickable {onFeederCreateSelect0()}
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun CreationSelectionItem(
    itemTitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_large))
        ) {
            Text(
                text = itemTitle,
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}