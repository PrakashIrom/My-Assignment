package com.example.intershipassignment.uidesign

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.intershipassignment.ui.theme.IntershipAssignmentTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun empList(modifier: Modifier=Modifier,navController: NavHostController){
    val allEmp = listOf(
        "Boon",
        "Apui",
        "Disha",
        "Hector",
        "Prakash",
        "Alice",
        "Bob",
        "Charlie",
        "David",
        "Emma",
        "Frank",
        "Grace",
        "Henry",
        "Ivy",
        "Jack",
        "Katherine",
        "Liam",
        "Mia",
        "Noah",
        "Olivia"
    )

    var searchQuery by remember { mutableStateOf("") }

    Surface(color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()) {

    }
            Column(
                modifier = modifier
            ) {
                Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)){
                    //space for home button
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home Icon",
                        modifier
                            .size(30.dp)
                            .clickable {
                                navController.navigate("home")
                            }
                    )
                    Spacer(modifier = Modifier.padding(160.dp,0.dp,0.dp,0.dp))
                    Icon(imageVector = Icons.Default.Face, contentDescription = "Home Icon",
                        modifier
                            .size(30.dp)
                            .clickable {
                                navController.navigate("home")
                            }
                    )
                    //Spacer(modifier.size(10.dp))
                    Text(text = "Employee List",
                        style = TextStyle(color = Color.Black, fontSize = 25.sp),
                    )
                }
                TextField(
                    value = searchQuery, onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text("Search Employee") },
                    shape = RoundedCornerShape(48.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                // Filtered list of employees based on search query
                val filteredEmployees = if (searchQuery.isEmpty()) allEmp else allEmp.filter {
                    it.contains(
                        searchQuery,
                        ignoreCase = true
                    )
                }

                // Display filtered employees
                LazyColumn(modifier.padding(20.dp, 20.dp, 20.dp, 20.dp)) {
                    items(filteredEmployees) { employee ->
                        Card(
                            modifier
                                .padding(0.dp, 0.dp, 0.dp, 10.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(Color.LightGray)
                        ) {
                              Row(verticalAlignment = Alignment.CenterVertically) {
                                  Icon(imageVector = Icons.Default.Person,
                                      contentDescription = "Home Icon",
                                      modifier
                                          .size(30.dp)
                                          .clickable {
                                              navController.navigate("home")
                                          }
                                  )
                                  Text(
                                      text = employee,
                                      style = TextStyle(color = Color.Black, fontSize = 30.sp),
                                  )
                              }
                        }
                    }
                }
            }
}

@Preview(showBackground = true)
@Composable
fun employeeListPreview(){
    val navController = rememberNavController()
    IntershipAssignmentTheme {
        empList(navController = navController)
    }
}