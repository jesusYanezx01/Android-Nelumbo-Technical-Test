package com.example.nelumbotechnicaltest.data.models

data class Request(
    val id: Int,
    val name: String?,
    val description: String?,
    val type: String?,
    val area: Area?,
    val createTime: String,
    val department: Department?,
    val priority: Priority?,
    val store: Store?,
    val status: Status?,
    val category: Category?,
    val subcategory: SubCategory?,
    val createdByUser: User?,
    val reportFolioUserAssign: List<User?>?,
    val userAttendingId: Int?,
)
