package com.example.nelumbotechnicaltest.data.models

data class Request(
    val id: Int,
    val name: String?,
    val description: String?,
    val area: Area,
    val department: Department,
    val priority: Priority?,
    val store: Store,
    val status: Status,
    val category: Category?,
    val subcategory: SubCategory?,
    val createdByUser: User?,
    val reportFolioUserAssign: User?
)