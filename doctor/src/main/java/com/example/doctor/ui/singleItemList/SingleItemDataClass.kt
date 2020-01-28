package com.example.doctor.ui.singleItemList

data class SingleItemDataClass(var listItems: List<SingleItemModel>)

data class SingleItemModel(
    var index: Int,
    var caption: String
)
