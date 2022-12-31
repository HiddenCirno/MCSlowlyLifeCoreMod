package com.iouter.slowlylife.common;

import com.iouter.slowlylife.SlowlyLife;
import com.iouter.slowlylife.Tags;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSlowlyLife extends CreativeTabs {

    public CreativeTabSlowlyLife(String lable) {
        super(Tags.MODNAME);
    }

    @Override
    public Item getTabIconItem() {
        return SlowlyLife.t3crystal;
    }
}
