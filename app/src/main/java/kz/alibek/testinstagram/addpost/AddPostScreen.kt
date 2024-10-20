package kz.alibek.testinstagram.addpost

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddPostScreen(
    uiState: AddPostUiState,
    onAction: (AddPostAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "New post",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = { onAction(AddPostAction.OnAddPost) }
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Default.Add),
                        contentDescription = null
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = uiState.imageUrlTextField,
                onValueChange = { onAction(AddPostAction.OnImageUrlValueChanged(it)) },
                maxLines = 1,
                label = {
                    Text(text = "Image url")
                },
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = uiState.captionTextField,
                onValueChange = { onAction(AddPostAction.OnCaptionValueChanged(it)) },
                maxLines = 1,
                label = {
                    Text(text = "Caption")
                },
            )
        }
    }
}