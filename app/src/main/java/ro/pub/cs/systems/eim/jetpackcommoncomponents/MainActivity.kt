package ro.pub.cs.systems.eim.jetpackcommoncomponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<MainViewModel>()
        setContent {
            MaterialTheme {
                DemoScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun DemoScreen(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "hello, jetpack compose", style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.size(8.dp))

        Button(onClick = { viewModel.incrementClickCount() }) {
            Text("Clicked ${viewModel.clickCount.value} times")
        }
        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = viewModel.text.value,
            onValueChange = {
                viewModel.updateText(it)
                Log.d("TextFieldComponent", "The text entered is: ${it.text}")
            },
            label = { Text("Enter text") }
        )
        Spacer(modifier = Modifier.size(8.dp))

        Text(text = "The text entered is: ${viewModel.text.value.text} and there are ${viewModel.clickCount.value} clicks.")

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = viewModel.checked.value,
                onCheckedChange = {
                    viewModel.updateChecked(it)
                    Log.d("CheckboxComponent", "The checkbox is checked: $it")
                }
            )
            Text("I agree to terms and conditions")
        }
        Text(text = "The checkbox is checked: ${viewModel.checked.value}")
        Spacer(modifier = Modifier.size(8.dp))

        Card {
            Text(text = "Card content")
        }
        Spacer(modifier = Modifier.size(8.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Demo Image",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.size(8.dp))
    }
}
