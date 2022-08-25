package com.realityexpander.processdeath

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.realityexpander.processdeath.ui.theme.ProcessDeathTheme
import kotlinx.parcelize.Parcelize


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProcessDeathTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel = viewModel<MainViewModel>()

                    val counter2 = rememberSaveable { mutableStateOf(0) }
                    val counter3 = remember { mutableStateOf(0) }

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            Alignment.CenterHorizontally
                        ) {
                            // Saved & restored - after process death using ViewModel
                            Button(
                                onClick = {
                                    viewModel.onCountClick()
                                }
                            ) {
                                Text(text = "Count: ${viewModel.counter}")
                            }

                            // Saved & restored - after process death using RememberSaveable
                            Button(
                                onClick = {
                                    counter2.value++
                                }
                            ) {
                                Text(text = "Count2: ${counter2.value}")
                            }

                            // NOT saved after process death
                            Button(
                                onClick = {
                                    counter3.value++
                                }
                            ) {
                                Text(text = "Count3: ${counter3.value}")
                            }

                            Text(text = "user: ${viewModel.user}")

                        }
                    }
                }
            }
        }
    }
}
