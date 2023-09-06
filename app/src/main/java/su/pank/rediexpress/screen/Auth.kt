package su.pank.rediexpress.screen

import android.graphics.fonts.Font
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import su.pank.rediexpress.ui.theme.RediExpressTheme
import su.pank.rediexpress.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Auth(viewModel: AuthViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(24.dp)) {
        Text(text = "Create an account", style = MaterialTheme.typography.titleLarge)
        Text(
            text = "Complete the sign up process to get started",
            style = MaterialTheme.typography.labelSmall
        )
        Text(text = "Full Name", style = MaterialTheme.typography.labelSmall)
        OutlinedTextField(
            value = viewModel.fullName,
            onValueChange = { viewModel.fullName = it },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun previewAuth() {
    RediExpressTheme {
        Auth()
    }
}