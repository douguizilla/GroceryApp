package com.odougle.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odougle.groceryapp.ui.theme.GroceryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun MainTheme(content: @Composable () -> Unit) {
    GroceryAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Box {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header Background",
            contentScale = ContentScale.FillWidth
        )
        Scaffold(
            topBar = { AppBar() },
            backgroundColor = Color.Transparent
        ) { paddingValues ->
            Content(paddingValues)

        }
    }
}

@Composable
fun AppBar() {
    Row(
        Modifier
            .padding(16.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Search Food, Vegetable, etc.", fontSize = 12.sp) },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search"
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "",
                tint = Color.White
            )
        }
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "",
                tint = Color.White
            )
        }


    }
}

@Composable
fun Content(paddingValues: PaddingValues) {
    Column(Modifier.padding(paddingValues)) {
        Header()
    }
}

@Composable
fun Header() {
    Card(
        Modifier
            .height(64.dp)
            .padding(16.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            QrButton()
            VerticalDivider()
            Row (
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp)
                    ){
                Icon(painter = painterResource(id = R.drawable.ic_money), contentDescription = "")
            }
        }
    }
}

@Composable
fun QrButton() {
    IconButton(
        onClick = {},
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Composable
fun VerticalDivider() {
    Divider(
        color = Color(0xFFF1F1F1), modifier = Modifier
            .width(1.dp)
            .height(32.dp)
    )
}


//video https://www.youtube.com/watch?v=pFZO5olP6HU&t=63 min 3:16