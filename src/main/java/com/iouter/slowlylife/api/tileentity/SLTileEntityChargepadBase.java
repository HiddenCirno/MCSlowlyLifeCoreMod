package com.iouter.slowlylife.api.tileentity;

import com.iouter.slowlylife.api.blocks.SLBlockChargepadBase;
import ic2.core.block.wiring.BlockChargepad;
import ic2.core.block.wiring.TileEntityChargepadBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public abstract class SLTileEntityChargepadBase extends TileEntityChargepadBlock {

    private final String name;

    public SLTileEntityChargepadBase(String name, int tier1, int output1, int maxStorage1) {
        super(tier1, output1, maxStorage1);
        this.name = name;
    }

    @Override
    protected void getItems(EntityPlayer player) {
        if (player != null) {
            ItemStack[] stacks = player.inventory.armorInventory;
            int stacksLength = stacks.length;

            int i;
            ItemStack current;
            for (i = 0; i < stacksLength; ++i) {
                current = stacks[i];
                if (current != null) {
                    this.chargeitems(current, getOutput());
                }
            }

            stacks = player.inventory.mainInventory;
            stacksLength = stacks.length;

            for (i = 0; i < stacksLength; ++i) {
                current = stacks[i];
                if (current != null) {
                    this.chargeitems(current, getOutput());
                }
            }
        }
    }

    @Override
    public String getInventoryName() {
        return name;
    }
}
