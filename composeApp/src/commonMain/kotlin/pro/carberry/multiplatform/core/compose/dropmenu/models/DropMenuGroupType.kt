package pro.carberry.multiplatform.core.compose.dropmenu.models

import pro.carberry.multiplatform.core.compose.dropmenu.models.OrderScreenType.ExtraInfo
import pro.carberry.multiplatform.core.compose.dropmenu.models.OrderScreenType.File
import pro.carberry.multiplatform.core.compose.dropmenu.models.OrderScreenType.MainInfo

enum class DropMenuGroupType(val groupName: String, val type: OrderScreenType) {
    VehicleType("Vehicle type", MainInfo),
    Manufacturer("Manufacturer", MainInfo),
    Model("Model", MainInfo),
    Engine("Engine", MainInfo),
    ECUType("ECU type", MainInfo),
    GearboxType("Gearbox type", ExtraInfo),
    OriginalFile("Is file original?", File),
    ReadingMethod("Reading method", File),
    Priority("Priority", File)
}

enum class OrderScreenType {
    MainInfo, ExtraInfo, File
}
