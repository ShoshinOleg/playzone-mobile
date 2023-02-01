package widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import theme.Theme

@Composable
fun CommonTextField(
    text: String,
    hint: String,
    enabled: Boolean = true,
    isSecure: Boolean = false,
    trailingIcon: @Composable () -> Unit = {},
    onValueChanged: (String) -> Unit = {}
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        enabled = enabled,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF_1F2430),
            textColor = Theme.colors.secondaryTextColor,
            cursorColor = Theme.colors.highlightTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        visualTransformation = if (isSecure) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        placeholder = {
            Text(text = hint, color = Theme.colors.hintTextColor)
        },
        shape = RoundedCornerShape(10.dp),
        trailingIcon = { trailingIcon.invoke() },
        onValueChange = { onValueChanged.invoke(it) }
    )
}