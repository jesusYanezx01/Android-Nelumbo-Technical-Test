package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.response.RequestResponse
import com.example.nelumbotechnicaltest.domain.model.Request
import javax.inject.Inject

class RequestMapper @Inject constructor(
    private val areaMapper: AreaMapper,
    private val departmentMapper: DepartmentMapper,
    private val priorityMapper: PriorityMapper,
    private val storeMapper: StoreMapper,
    private val statusMapper: StatusMapper,
    private val userMapper: UserMapper
) {

    fun mapResponseToRequest(
        requestResponse: RequestResponse?,
    ): Request? {
        return requestResponse?.let {
            Request(
                id = it.id,
                name = it.name,
                description = it.description,
                type = it.type,
                area = areaMapper.mapAreaResponseToArea(it.area),
                createTime = it.createTime,
                department = departmentMapper.mapResponseToDepartment(it.department),
                priority = priorityMapper.mapResponseToPriority(it.priority),
                store = storeMapper.mapResponseToStore(it.store),
                status = statusMapper.mapResponseToStatus(it.status),
                createdByUser = userMapper.mapResponseToUser(it.createdByUser),
                reportFolioUserAssign = it.reportFolioUserAssign?.map { userResponse ->
                    userMapper.mapResponseToUser(userResponse)
                },
                userAttendingId = it.userAttendingId
            )
        }
    }

    fun mapResponseToRequestList(
        requestResponseList: List<RequestResponse>?,
    ): List<Request>? {
        return requestResponseList?.map {
            Request(
                id = it.id,
                name = it.name,
                description = it.description,
                type = it.type,
                area = areaMapper.mapAreaResponseToArea(it.area),
                createTime = it.createTime,
                department = departmentMapper.mapResponseToDepartment(it.department),
                priority = priorityMapper.mapResponseToPriority(it.priority),
                store = storeMapper.mapResponseToStore(it.store),
                status = statusMapper.mapResponseToStatus(it.status),
                createdByUser = userMapper.mapResponseToUser(it.createdByUser),
                reportFolioUserAssign = it.reportFolioUserAssign?.map { userResponse ->
                    userMapper.mapResponseToUser(userResponse)
                },
                userAttendingId = it.userAttendingId
            )
        }
    }
}
