package com.example.nelumbotechnicaltest.data.data.response

import com.google.gson.annotations.SerializedName

data class RequestResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("area")
    val area: AreaResponse?,
    @SerializedName("createTime")
    val createTime: String,
    @SerializedName("department")
    val department: DepartmentResponse?,
    @SerializedName("priority")
    val priority: PriorityResponse?,
    @SerializedName("store")
    val store: StoreResponse?,
    @SerializedName("status")
    val status: StatusResponse?,
    @SerializedName("createdByUser")
    val createdByUser: UserResponse?,
    @SerializedName("reportFolioUserAssign")
    val reportFolioUserAssign: List<UserResponse?>?,
    @SerializedName("userAttendingId")
    val userAttendingId: Int?,
)
