package com.example.workmanagerinclean.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkInfo
import com.example.workmanagerinclean.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(private val repo: PostRepository) : ViewModel() {

    init {
        getPost()
    }

    private fun getPost() {
        viewModelScope.launch {
            repo.getPost().collect{
                if(it.state == WorkInfo.State.SUCCEEDED){
                    val outPut = it.outputData.getString("responseString")
                }
            }
        }

    }

    fun onEvent(event: MainUiEvent) {
        when (event) {
            is MainUiEvent.GetPost -> {
                getPost()
            }
        }
    }
}