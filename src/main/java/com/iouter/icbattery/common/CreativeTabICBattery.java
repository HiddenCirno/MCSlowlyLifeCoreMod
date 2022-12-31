package com.iouter.icbattery.common;

import com.iouter.icbattery.ICBattery;
import com.iouter.icbattery.Tags;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabICBattery extends CreativeTabs {

    public CreativeTabICBattery(String lable) {
        super(Tags.MODNAME);
    }

    @Override
    public Item getTabIconItem() {
        return ICBattery.t3crystal;
    }
}
