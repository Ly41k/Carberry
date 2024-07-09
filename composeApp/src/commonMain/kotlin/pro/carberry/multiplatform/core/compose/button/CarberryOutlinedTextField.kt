package pro.carberry.multiplatform.core.compose.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import pro.carberry.multiplatform.theme.AppTheme
import pro.carberry.multiplatform.theme.DefaultOutlinedTextFieldColors

@[Stable Composable]
fun CarberryOutlinedTextField(
    modifier: Modifier,
    text: String,
    hint: String,
    placeholder: String = "",
    enabled: Boolean = true,
    isSecure: Boolean = false,
    isError: Boolean = false,
    errorMessage: String = "",
    keyboardType: KeyboardType = KeyboardType.Password,
    trailingIcon: @Composable () -> Unit = {},
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        singleLine = true,
        colors = DefaultOutlinedTextFieldColors(),
        visualTransformation = if (isSecure) PasswordVisualTransformation() else VisualTransformation.None,
        label = { Label(hint) },
        placeholder = { Label(placeholder) },
        shape = RoundedCornerShape(10.dp),
        trailingIcon = { trailingIcon.invoke() },
        isError = isError,
        supportingText = { SupportingText(isError, errorMessage) },
        enabled = enabled,
        onValueChange = { onValueChanged(it) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

@[Stable Composable]
private fun SupportingText(isError: Boolean, errorMessage: String) {
    if (isError) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = errorMessage,
            style = AppTheme.typography.label,
            color = AppTheme.colors.error
        )
    }
}

@[Stable Composable]
private fun Label(hint: String) {
    Text(text = hint, color = AppTheme.colors.secondaryText)
}