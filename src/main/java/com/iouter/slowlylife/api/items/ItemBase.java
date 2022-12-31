package com.iouter.slowlylife.api.items;

import com.iouter.slowlylife.SlowlyLife;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public abstract class ItemBase extends Item {
    public ItemBase() {
        super();
        this.setCreativeTab(SlowlyLife.creativeTabSlowlyLife);
    }
}
