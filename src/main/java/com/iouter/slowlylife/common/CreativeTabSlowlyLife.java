package com.iouter.slowlylife.common;

import com.iouter.slowlylife.Tags;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSlowlyLife extends CreativeTabs {

    public CreativeTabSlowlyLife() {
        super(Tags.MODNAME);
    }

    @Override
    public Item getTabIconItem() {
        return Resiger.t3crystal;
    }
}
