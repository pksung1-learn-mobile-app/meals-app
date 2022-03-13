package com.example.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.MealsRepository
import com.example.mealzapp.model.response.MealResponse
import com.example.mealzapp.model.response.MealsCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealCategoriesViewModel(private val repository: MealsRepository = MealsRepository.getInstance()): ViewModel() {

    private val mealsJob = Job()
    init {

//        Log.d("TAG_COROUTINES", "we are about to launch a coroutine") // 1
//        val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        viewModelScope.launch(Dispatchers.IO) {
//            Log.d("TAG_COROUTINES", "we have launched the coroutine") // 3
            val meals = getMeals()
            mealsState.value = meals
//            Log.d("TAG_COROUTINES", "we have launched async data") // 4
        }
//        Log.d("TAG_COROUTINES", "other work") // 2
    }

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

//    override fun onCleared() {
//        super.onCleared()
//        mealsJob.cancel()
//    }

    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}