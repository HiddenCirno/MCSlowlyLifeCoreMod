package com.iouter.slowlylife.api.blocks;

import com.iouter.slowlylife.SlowlyLife;
import com.iouter.slowlylife.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SLBlockBase extends Block {
    protected SLBlockBase(Material material, String name) {
        super(material);
        this.setCreativeTab(SlowlyLife.creativeTabSlowlyLife);
        this.setBlockName(name);
        this.setBlockTextureName(Tags.MODID + ":" + getUnlocalizedName());
    }
}
