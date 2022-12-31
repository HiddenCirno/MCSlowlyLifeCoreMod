package com.iouter.icbattery.tileentity;

import ic2.core.block.wiring.TileEntityElectricBlock;

public class TileEntityElectric extends TileEntityElectricBlock {
    private final String name;

    public TileEntityElectric(String name, int tier, int maxOutput, int maxStorage) {
        super(tier, maxOutput, maxStorage);
        this.name = name;
    }

    @Override
    public String getInventoryName() {
        return name;
    }
}
