package com.iouter.slowlylife.api.blocks;

import com.iouter.slowlylife.SlowlyLife;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    protected BlockBase(Material material) {
        super(material);
        this.setCreativeTab(SlowlyLife.creativeTabSlowlyLife);
    }
}
