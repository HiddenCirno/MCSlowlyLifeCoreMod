package com.iouter.slowlylife.api.blocks;

import com.iouter.slowlylife.SlowlyLife;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockBasic extends ItemBlock {

    public ItemBlockBasic(Block block) {
        super(block);
        this.setCreativeTab(SlowlyLife.creativeTabSlowlyLife);
    }
}
