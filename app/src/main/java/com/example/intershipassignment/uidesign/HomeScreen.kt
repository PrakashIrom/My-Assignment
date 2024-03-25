package com.example.intershipassignment.uidesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.intershipassignment.R
import com.example.intershipassignment.ui.theme.IntershipAssignmentTheme

@Composable
fun homeScreen(modifier: Modifier=Modifier,navController: NavHostController){
    
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center ){
        Image(painter = painterResource(id = R.drawable.pexels_cottonbro_studio_4065906),
            contentDescription = null,
            modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
            )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                navController.navigate("employee")
            }
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "User Icon",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "User",
                style = TextStyle(color = Color.Black, fontSize = 70.sp),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun previewHomeScreen(){
    val navController = rememberNavController()
    IntershipAssignmentTheme {
        homeScreen(navController = navController)
    }
}

