package com.jetpack.liftonscroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.liftonscroll.ui.theme.LiftOnScrollTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiftOnScrollTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LiftOnScroll()
                }
            }
        }
    }
}

@Composable
fun LiftOnScroll() {
    val lazyListState = rememberLazyListState()

    Column {
        AppBar(
            title = "Lift On Scroll",
            elevation = lazyListState.elevation
        )
        LazyColumn(state = lazyListState) {
            item {
                Text(
                    text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",
                    color = Color.Black,
                    modifier = Modifier.padding(15.dp)
                )
            }
            items(20) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(10.dp, 5.dp, 10.dp, 5.dp)
                        .background(Color.White),
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(5.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cat),
                                contentDescription = "Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.padding(5.dp))

                            Column {
                                Text(
                                    text = "Make it Easy ${index + 1}",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.padding(2.dp))

                                Text(
                                    text = "Lorem Ipsum is simply item ${index + 1}",
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AppBar(
    title: String,
    elevation: Dp
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.Black
            )
        },
        elevation = elevation,
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "NavigationMenu",
                    tint = Color.Black
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = "Menu",
                    tint = Color.Black
                )
            }
        }
    )
}

val LazyListState.elevation: Dp
    get() = if (firstVisibleItemIndex == 0) {
        minOf(firstVisibleItemScrollOffset.toFloat().dp, AppBarDefaults.TopAppBarElevation)
    } else {
        AppBarDefaults.TopAppBarElevation
    }



















