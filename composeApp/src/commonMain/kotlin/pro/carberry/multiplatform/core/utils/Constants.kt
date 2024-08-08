package pro.carberry.multiplatform.core.utils

object Constants {
    const val DEFAULT_DISPATCHER_QUALIFIER = "DefaultDispatcher"
    const val IO_DISPATCHER_QUALIFIER = "IODispatcher"
    const val MAIN_DISPATCHER_QUALIFIER = "MainDispatcher"

    const val MOCK_MAIN_INFO_DATA_SOURCE_QUALIFIER = "MockMainInfoDataSource"
    const val MOCK_SERVICES_DATA_SOURCE_QUALIFIER = "MockServicesDataSource"

    // TODO Need to use properties file
    const val CONTACT_EMAIL: String = "info@carberry.pro"

    const val VEHICLE_TYPE_MOCK_PATH: String = "files/neworder/mock_vehicle_type.json"
    const val MANUFACTURER_MOCK_PATH: String = "files/neworder/mock_manufacturer.json"
    const val MODEL_MOCK_PATH: String = "files/neworder/mock_model.json"
    const val ENGINE_MOCK_PATH: String = "files/neworder/mock_engine.json"
    const val ECU_TYPE_MOCK_PATH: String = "files/neworder/mock_ecu_type.json"
    const val SERVICES_MOCK_PATH: String = "files/neworder/mock_services.json"
}
