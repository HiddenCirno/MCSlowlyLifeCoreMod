package com.iouter.slowlylife.api.items;

import com.iouter.slowlylife.common.Resiger;
import com.iouter.slowlylife.Tags;
import net.minecraft.item.Item;

public abstract class SLItemBase extends Item {
    public SLItemBase(String name) {
        super();
        this.setCreativeTab(Resiger.creativeTabSlowlyLife);
        this.setUnlocalizedName(name);
        this.setTextureName(Tags.MODID + ":" + getUnlocalizedName());
    }
}
