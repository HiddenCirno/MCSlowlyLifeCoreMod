package com.iouter.slowlylife.api.items;

import com.iouter.slowlylife.SlowlyLife;
import com.iouter.slowlylife.Tags;
import net.minecraft.item.Item;

public abstract class SLItemBase extends Item {
    public SLItemBase(String name) {
        super();
        this.setCreativeTab(SlowlyLife.creativeTabSlowlyLife);
        this.setUnlocalizedName(name);
        this.setTextureName(Tags.MODID + ":" + getUnlocalizedName());
    }
}
