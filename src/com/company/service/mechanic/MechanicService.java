package com.company.service.mechanic;

import com.company.model.vehicle.Brand;
import com.company.model.vehicle.PartName;

public interface MechanicService {
    boolean hireMechanicJanusz(Brand brand, PartName part);
    boolean hireMechanicMarian(Brand brand, PartName part);
    boolean hireMechanicAdrian(Brand brand, PartName part);
    void washCar();
}
