package com.iouter.slowlylife.items;

import com.iouter.slowlylife.api.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemCommon extends ItemBase {
    public ItemCommon(String name) {
        super();
        setUnlocalizedName(name);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean isF3) {
        for (int i = 0; ; i++) {
            String tooltip = StatCollector.translateToLocal(getUnlocalizedName() +".tooltip." + i);
            if ((getUnlocalizedName() +".tooltip." + i) != tooltip)
                list.add(StatCollector.translateToLocal(getUnlocalizedName() +".tooltip." + i));
            else
                break;
        }
    }
}
