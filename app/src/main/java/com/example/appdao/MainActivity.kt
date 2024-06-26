package com.example.appdao

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdao.db.model.Note
import com.example.appdao.home.EditDialog
import com.example.appdao.ui.model.Event
import com.example.appdao.ui.model.NoteViewModel
import com.example.appdao.ui.model.NoteViewModelFactory
import com.example.appdao.ui.theme.AppdaoTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch



@Composable
@Preview(showBackground = true)
fun EditDialogPreview() {
    var openDialog by remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("") }

    EditDialog(
        openDialog = openDialog,
        text = text,
        onEvent = { event ->
            when (event) {
                is Event.CloseDialog -> openDialog = false
                is Event.Save -> {
                    // Handle save action
                    openDialog = false
                }
                is Event.SetText -> text = event.text
                is Event.Delete -> {
                    // Handle delete action if needed
                }
                is Event.Load -> {
                    // Handle load action if needed
                }
                is Event.OpenDialog -> openDialog = true
            }
        }
    )
}