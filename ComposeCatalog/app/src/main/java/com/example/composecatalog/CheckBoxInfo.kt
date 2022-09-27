package com.example.composecatalog

data class CheckBoxInfo(
    val title : String,
    var isChecked : Boolean,
    var isChangeCheck : (Boolean) -> Unit
)
