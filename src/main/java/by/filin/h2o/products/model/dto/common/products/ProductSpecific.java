package by.filin.h2o.products.model.dto.common.products;

public sealed interface ProductSpecific
        permits DesktopRequestSpecific,
        LaptopRequestSpecific,
        MonitorRequestSpecific,
        HardDriveRequestSpecific {
}