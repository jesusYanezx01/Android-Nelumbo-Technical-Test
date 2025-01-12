package com.example.nelumbotechnicaltest.data.api_models

import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("area")
    val area: Area?,
    @SerializedName("createTime")
    val createTime: String,
    @SerializedName("department")
    val department: Department?,
    @SerializedName("priority")
    val priority: Priority?,
    @SerializedName("store")
    val store: Store?,
    @SerializedName("status")
    val status: Status?,
    @SerializedName("createdByUser")
    val createdByUser: User?,
    @SerializedName("reportFolioUserAssign")
    val reportFolioUserAssign: List<User?>?,
    @SerializedName("userAttendingId")
    val userAttendingId: Int?,
)
