package su.pank.rediexpress.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel()
{
    var fullName by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
    var emailAddress by mutableStateOf("")

}
