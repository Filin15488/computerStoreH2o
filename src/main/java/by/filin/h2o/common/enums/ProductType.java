package by.filin.h2o.common.enums;

import by.filin.h2o.desktopComputer.model.entity.DesktopComputer;
import by.filin.h2o.hardDrive.model.entity.HardDrive;
import by.filin.h2o.laptop.model.entity.Laptop;
import by.filin.h2o.monitor.model.entity.Monitor;
import by.filin.h2o.products.model.entity.Product;

public enum ProductType {
    DESKTOP(DesktopComputer.class),
    LAPTOPS(Laptop.class),
    MONITORS(Monitor.class),
    HARD_DRIVES(HardDrive.class);

    private final Class<? extends Product> entityClass;

    ProductType(Class<? extends Product> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<? extends Product> getEntityClass() {
        return entityClass;
    }
}