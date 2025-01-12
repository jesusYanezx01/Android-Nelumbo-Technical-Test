package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.response.DepartmentResponse
import com.example.nelumbotechnicaltest.domain.model.Department
import javax.inject.Inject

class DepartmentMapper @Inject constructor(
    private val userMapper: UserMapper
) {
    fun mapResponseToDepartment(departmentResponse: DepartmentResponse?): Department? {
        return departmentResponse?.let {
            Department(
                name = it.name,
                userManage = userMapper.mapResponseToUser(it.userManage)
            )
        }
    }
}
