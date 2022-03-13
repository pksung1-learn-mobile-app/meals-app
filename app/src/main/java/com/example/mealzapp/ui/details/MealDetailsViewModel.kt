package com.example.mealzapp.ui.details

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealsRepository
import com.example.mealzapp.model.response.MealResponse

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    var mealState = mutableStateOf<MealResponse?>(null)
    private val repository: MealsRepository = MealsRepository.getInstance()

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        Log.d("TAG_CATEGORY", mealId)
        mealState.value = repository.getMeal(mealId)
    }
}