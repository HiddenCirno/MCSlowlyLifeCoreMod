package com.iouter.slowlylife.api.blocks;

import com.iouter.slowlylife.common.Resiger;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class SLItemBlockBase extends ItemBlock {

    public SLItemBlockBase(Block block) {
        super(block);
        this.setCreativeTab(Resiger.creativeTabSlowlyLife);
    }
}
