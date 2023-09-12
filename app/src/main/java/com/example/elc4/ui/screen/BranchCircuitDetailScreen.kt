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
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.elc4.ELC4TopAppBar
import com.example.elc4.R
import com.example.elc4.ui.navigation.NavigationDestination

object BranchCircuitDetailScreenDestination : NavigationDestination {
    override val route = "detail_branchCircuit"
    override val titleRes = R.string.titleRes_branchCircuitDetail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BranchCircuitDetailScreen(
    canNavigateBack: Boolean = true,
    onNavigateBackward: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = stringResource(R.string.conDes_projectCreate)
                )
            }
        },
        topBar = {
            ELC4TopAppBar(
                canNavigateBack = canNavigateBack,
                navigateBackward = onNavigateBackward,
                scrollBehavior = scrollBehavior,
                topBarTitle = stringResource(BranchCircuitDetailScreenDestination.titleRes)
            )
        },
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        BranchCircuitDetailBody(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun BranchCircuitDetailBody(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_medium)),
    ) {
        BranchCircuitDetailList(
            modifier = Modifier
                .fillMaxWidth()
        )

        /*
        Text(
            text = stringResource(R.string.desc_branchCircuitDetail_sample),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        */
    }
}

@Composable
fun BranchCircuitDetailList(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            BranchCircuitDetail(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Preview
@Composable
fun BranchCircuitDetail(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            verticalArrangement = Arrangement
                .spacedBy(dimensionResource(id = R.dimen.padding_medium)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
            ) {
            BranchCircuitDetailRow(
                detailTitle = "Lighting Outlet",
                detailValue = "1",
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen
                        .padding_medium)
                )
            )
            BranchCircuitDetailRow(
                detailTitle = "Load Power:",
                detailValue = "1500 VA",
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen
                        .padding_medium)
                )
            )
            BranchCircuitDetailRow(
                detailTitle = "Load Current:",
                detailValue = "6.522 A",
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen
                        .padding_medium)
                )
            )
        }
    }
}

@Composable
fun BranchCircuitDetailRow(
    detailTitle: String,
    detailValue: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(detailTitle)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = detailValue,
            fontWeight = FontWeight.Bold
        )
    }
}