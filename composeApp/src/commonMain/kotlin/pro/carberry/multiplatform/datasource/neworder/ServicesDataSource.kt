package pro.carberry.multiplatform.datasource.neworder

import pro.carberry.multiplatform.datasource.neworder.models.NewOrderServicesResponse

interface ServicesDataSource {
    suspend fun fetchServices(ecuTypeId: Long?): List<NewOrderServicesResponse>
}
