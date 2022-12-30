package com.iouter.icbattery.items;

import com.iouter.icbattery.ICBattery;
import net.minecraft.item.Item;

public abstract class ItemBasic extends Item {
    public ItemBasic() {
        super();
        this.setCreativeTab(ICBattery.creativeTabICBattery);
    }
}
