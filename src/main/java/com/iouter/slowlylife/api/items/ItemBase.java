package com.iouter.slowlylife.api.items;

import com.iouter.slowlylife.SlowlyLife;
import net.minecraft.item.Item;

public abstract class ItemBase extends Item {
    public ItemBase() {
        super();
        this.setCreativeTab(SlowlyLife.creativeTabSlowlyLife);
    }
}
