package com.iouter.slowlylife.api.tileentity;

import ic2.core.block.wiring.TileEntityElectricBlock;

public abstract class TileEntityElectricBase extends TileEntityElectricBlock {
    private final String name;

    public TileEntityElectricBase(String name, int tier, int maxOutput, int maxStorage) {
        super(tier, maxOutput, maxStorage);
        this.name = name;
    }

    @Override
    public String getInventoryName() {
        return name;
    }
}
