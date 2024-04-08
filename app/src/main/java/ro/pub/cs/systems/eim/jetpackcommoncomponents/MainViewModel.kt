package ro.pub.cs.systems.eim.jetpackcommoncomponents

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val clickCount: MutableState<Int> = mutableIntStateOf(0)
    val text: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    val checked: MutableState<Boolean> = mutableStateOf(false)

    fun incrementClickCount() {
        clickCount.value++
    }

    fun updateText(newValue: TextFieldValue) {
        text.value = newValue
    }

    fun updateChecked(newValue: Boolean) {
        checked.value = newValue
    }
}