package com.example.gridtopicsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridtopicsapp.model.Topic
import com.example.gridtopicsapp.data.DataSource.topics
import com.example.gridtopicsapp.ui.theme.GridTopicsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridTopicsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun TopicScreen(topics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        items(topics) { topic ->
            TopicItem(topic)
        }
    }
}

@Composable
fun TopicItem(topic: Topic, modifier: Modifier = Modifier) {
    Card(elevation = 4.dp) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.topicResourceId),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            Box(modifier = Modifier.padding(16.dp)) {
                Column {
                    Text(
                        text = stringResource(id = topic.topicResourceId),
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(

                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_grain),
                            contentDescription = "",
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = topic.numberOfCourses.toString(),
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridTopicsAppTheme {
        TopicScreen(topics = topics)
    }
}