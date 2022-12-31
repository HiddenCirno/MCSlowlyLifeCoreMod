package com.iouter.icbattery.api.blocks;

import com.iouter.icbattery.ICBattery;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    protected BlockBase(Material material) {
        super(material);
        this.setCreativeTab(ICBattery.creativeTabICBattery);
    }
}
