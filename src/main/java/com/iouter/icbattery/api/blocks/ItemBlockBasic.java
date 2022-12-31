package com.iouter.icbattery.api.blocks;

import com.iouter.icbattery.ICBattery;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockBasic extends ItemBlock {

    public ItemBlockBasic(Block block) {
        super(block);
        this.setCreativeTab(ICBattery.creativeTabICBattery);
    }
}
