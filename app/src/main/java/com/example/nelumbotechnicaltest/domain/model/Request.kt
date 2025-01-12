package com.example.nelumbotechnicaltest.domain.model

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
    val createdByUser: User?,
    val reportFolioUserAssign: List<User?>?,
    val userAttendingId: Int?
)
