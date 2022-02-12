package com.company.service.mechanic;

import com.company.model.mechanic.FixCostRate;
import com.company.model.vehicle.Brand;
import com.company.model.vehicle.PartName;

import java.util.ArrayList;
import java.util.List;

public class FixCostTableGenerator {

    public static List<FixCostRate> fixCostRates = new ArrayList<>();

    public void initFixCostRates() {
        fixCostRates = List.of(
                new FixCostRate(Brand.NISSAN, PartName.BREAKS, 1000),
                new FixCostRate(Brand.BMW, PartName.BREAKS, 1010),
                new FixCostRate(Brand.FIAT, PartName.BREAKS, 1020),
                new FixCostRate(Brand.TOYOTA, PartName.BREAKS, 1030),
                new FixCostRate(Brand.SKODA, PartName.BREAKS, 1040),
                new FixCostRate(Brand.VOLKSWAGEN, PartName.BREAKS, 1050),
                new FixCostRate(Brand.HONDA, PartName.BREAKS, 1060),
                new FixCostRate(Brand.SUBARU, PartName.BREAKS, 1070),
                new FixCostRate(Brand.MAZDA, PartName.BREAKS, 1080),
                new FixCostRate(Brand.MERCEDES, PartName.BREAKS, 1090),
                new FixCostRate(Brand.KIA, PartName.BREAKS, 1100),
                new FixCostRate(Brand.VOLVO, PartName.BREAKS, 1110),

                new FixCostRate(Brand.NISSAN, PartName.HANDLING, 2020),
                new FixCostRate(Brand.BMW, PartName.HANDLING, 2012),
                new FixCostRate(Brand.FIAT, PartName.HANDLING, 2032),
                new FixCostRate(Brand.TOYOTA, PartName.HANDLING, 2099),
                new FixCostRate(Brand.SKODA, PartName.HANDLING, 2023),
                new FixCostRate(Brand.VOLKSWAGEN, PartName.HANDLING, 2100),
                new FixCostRate(Brand.HONDA, PartName.HANDLING, 2800),
                new FixCostRate(Brand.SUBARU, PartName.HANDLING, 2400),
                new FixCostRate(Brand.MAZDA, PartName.HANDLING, 2200),
                new FixCostRate(Brand.MERCEDES, PartName.HANDLING, 2100),
                new FixCostRate(Brand.KIA, PartName.HANDLING, 2123),
                new FixCostRate(Brand.VOLVO, PartName.HANDLING, 2980),

                new FixCostRate(Brand.NISSAN, PartName.ENGINE, 3042),
                new FixCostRate(Brand.BMW, PartName.ENGINE, 3001),
                new FixCostRate(Brand.FIAT, PartName.ENGINE, 30400),
                new FixCostRate(Brand.TOYOTA, PartName.ENGINE, 3500),
                new FixCostRate(Brand.SKODA, PartName.ENGINE, 3200),
                new FixCostRate(Brand.VOLKSWAGEN, PartName.ENGINE, 3040),
                new FixCostRate(Brand.HONDA, PartName.ENGINE, 3099),
                new FixCostRate(Brand.SUBARU, PartName.ENGINE, 3080),
                new FixCostRate(Brand.MAZDA, PartName.ENGINE, 3070),
                new FixCostRate(Brand.MERCEDES, PartName.ENGINE, 3234),
                new FixCostRate(Brand.KIA, PartName.ENGINE, 3509),
                new FixCostRate(Brand.VOLVO, PartName.ENGINE, 3809),

                new FixCostRate(Brand.NISSAN, PartName.BODY, 3187),
                new FixCostRate(Brand.BMW, PartName.BODY, 3040),
                new FixCostRate(Brand.FIAT, PartName.BODY, 3050),
                new FixCostRate(Brand.TOYOTA, PartName.BODY, 3060),
                new FixCostRate(Brand.SKODA, PartName.BODY, 3070),
                new FixCostRate(Brand.VOLKSWAGEN, PartName.BODY, 3010),
                new FixCostRate(Brand.HONDA, PartName.BODY, 3100),
                new FixCostRate(Brand.SUBARU, PartName.BODY, 3200),
                new FixCostRate(Brand.MAZDA, PartName.BODY, 3300),
                new FixCostRate(Brand.MERCEDES, PartName.BODY, 3450),
                new FixCostRate(Brand.KIA, PartName.BODY, 3600),
                new FixCostRate(Brand.VOLVO, PartName.BODY, 3200),

                new FixCostRate(Brand.NISSAN, PartName.TRANSMISSION, 2312),
                new FixCostRate(Brand.BMW, PartName.TRANSMISSION, 2444),
                new FixCostRate(Brand.FIAT, PartName.TRANSMISSION, 2555),
                new FixCostRate(Brand.TOYOTA, PartName.TRANSMISSION, 2666),
                new FixCostRate(Brand.SKODA, PartName.TRANSMISSION, 2123),
                new FixCostRate(Brand.VOLKSWAGEN, PartName.TRANSMISSION, 2542),
                new FixCostRate(Brand.HONDA, PartName.TRANSMISSION, 2005),
                new FixCostRate(Brand.SUBARU, PartName.TRANSMISSION, 2002),
                new FixCostRate(Brand.MAZDA, PartName.TRANSMISSION, 2003),
                new FixCostRate(Brand.MERCEDES, PartName.TRANSMISSION, 2001),
                new FixCostRate(Brand.KIA, PartName.TRANSMISSION, 2040),
                new FixCostRate(Brand.VOLVO, PartName.TRANSMISSION, 2005)
        );
    }
}
