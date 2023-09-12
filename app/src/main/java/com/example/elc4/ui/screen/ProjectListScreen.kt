package com.example.elc4.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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

object ProjectListScreenDestination : NavigationDestination {
    override val route = "projectlist"
    override val titleRes = R.string.titleRes_projectList
}

//@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectListScreen(
    navigateToProjectCreateScreen: () -> Unit,
    navigateToMainPanelScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navigateToProjectCreateScreen()}, // est: Create new Project, to ProjectCreateScreen
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.conDes_projectCreate)
                )
            }
        },
        topBar = {
            ELC4TopAppBar(
                canNavigateBack = false, // est: can't NavigateBack cause we're in startDestination
                scrollBehavior = scrollBehavior,
                topBarTitle = stringResource(ProjectListScreenDestination.titleRes)
            )
        },
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {innerPadding ->
        ProjectListBody(
            onProjectClick1 = {navigateToMainPanelScreen()},
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun ProjectListBody(
    onProjectClick1: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        ProjectItemList(
            onProjectClick0 = {onProjectClick1()},
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
        )
        /*
        Text(
            text = stringResource(R.string.desc_projectList_empty),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        */
    }

}

@Composable
fun ProjectItemList(
    onProjectClick0: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            ProjectItem(
                modifier = Modifier
                    .clickable {onProjectClick0()}
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Preview
@Composable
fun ProjectItem(
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
                    .spacedBy(dimensionResource(id = R.dimen.padding_small)),
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_large)),
            ) {
                Text(
                    text = "Single Family Dwelling Unit",
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = "Mao Zedong",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}