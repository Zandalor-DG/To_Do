package com.example.to_do.ui.home_screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsState()

    when (val state = state.value) {
        is HomeScreenStates.IdleState -> {
            viewModel.obtainEvent(HomeScreenEvents.LoadToDoItems)
        }
        is HomeScreenStates.ErrorState -> {
            Text(state.message)
        }
        is HomeScreenStates.HomeState -> {
            MainState(paddingValues, state)
        }
        is HomeScreenStates.LoadingState -> {
            CircularProgressIndicator()
        }
    }
}

@Composable
private fun MainState(
    paddingValues: PaddingValues,
    state: HomeScreenStates.HomeState
) {
    var query = remember { "" }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(state.data.size) {
                GridContent(
                    title = state.data[it].title,
                    description = state.data[it].description
                )
            }
        }
    }
}

@Composable
fun GridContent(
    title: String,
    description: String
) {
    Card(
        modifier = Modifier.padding(4.dp)
    ) {
        Column {
            Text(
                text = title,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = description,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun HomeScreenPreview() {
    Scaffold { paddings ->
        HomeScreen(paddings)
    }
}
