package com.example.gridtopicsapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val topicResourceId: Int,
    val numberOfCourses: Int,
    @DrawableRes val imageResourceId: Int
)