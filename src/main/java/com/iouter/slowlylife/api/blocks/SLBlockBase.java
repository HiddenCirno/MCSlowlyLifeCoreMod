package com.iouter.slowlylife.api.blocks;

import com.iouter.slowlylife.common.Resiger;
import com.iouter.slowlylife.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SLBlockBase extends Block {
    protected SLBlockBase(Material material, String name) {
        super(material);
        this.setCreativeTab(Resiger.creativeTabSlowlyLife);
        this.setBlockName(name);
        this.setBlockTextureName(Tags.MODID + ":" + getUnlocalizedName());
    }
}
