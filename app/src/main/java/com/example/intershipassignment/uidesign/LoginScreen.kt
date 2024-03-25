package com.example.intershipassignment.uidesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.intershipassignment.ui.theme.IntershipAssignmentTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.intershipassignment.R
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

@Composable
fun loginScreen(modifier: Modifier=Modifier,navController: NavHostController){
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var showErrorDialog by remember { mutableStateOf(false) }

    Box(modifier =Modifier.fillMaxSize() ) {
        Image(painter = painterResource(id = R.drawable.pexels_todd_trapani_1535162),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier.matchParentSize()
            )
    }

    Column(modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        userName(value = email
            , onValueChange = { email = it }, modifier = modifier)
        Spacer(modifier = modifier.size(30.dp))
        passWord(password = password, onValueChange = { password = it })
        Spacer(modifier = modifier.size(30.dp))
        Button(onClick = {
            if (email.isEmpty() || password.isEmpty()) {
                showErrorDialog = true
                return@Button
            }
            val auth: FirebaseAuth = Firebase.auth
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        navController.navigate("home")
                    } else {
                        showErrorDialog = true
                    }
                }
        },
            colors = ButtonDefaults.buttonColors( containerColor = Color.White)
            ) {
            Text(text = "Login",color=Color.Black)
        }
        Text(
            text = "Don't have an account? Create",
            color= Color.Cyan,
            modifier = Modifier.clickable {
                navController.navigate("create")
            }
        )

        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text("Error") },
                text = { Text("Invalid username or password") },
                confirmButton = {
                    Button(
                        onClick = { showErrorDialog = false }
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun userName(value: String, onValueChange:(String)->Unit,modifier: Modifier=Modifier){
    TextField(value = value,
        onValueChange = onValueChange,
        label={Text("User Name")},
        shape = RoundedCornerShape(20.dp)
        )
}

@Composable
fun passWord(password: String, onValueChange: (String) -> Unit){
    TextField(value = password,
        onValueChange = onValueChange,
        label={Text("Password")},
        visualTransformation = PasswordVisualTransformation(),
        shape = RoundedCornerShape(20.dp)
        )
}

@Preview(showBackground = true)
@Composable
fun prevScreen(){
    val navController = rememberNavController()
    IntershipAssignmentTheme {
    loginScreen(navController = navController)

    }
}