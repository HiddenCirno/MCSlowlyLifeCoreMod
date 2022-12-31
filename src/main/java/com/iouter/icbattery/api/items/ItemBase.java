package com.iouter.icbattery.api.items;

import com.iouter.icbattery.ICBattery;
import net.minecraft.item.Item;

public abstract class ItemBase extends Item {
    public ItemBase() {
        super();
        this.setCreativeTab(ICBattery.creativeTabICBattery);
    }
}
