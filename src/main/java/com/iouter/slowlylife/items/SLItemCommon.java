package com.iouter.slowlylife.items;

import com.iouter.slowlylife.api.items.SLItemBase;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class SLItemCommon extends SLItemBase {
    public SLItemCommon(String name) {
        super(name);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean isF3) {
        for (int i = 0; ; i++) {
            String tooltip = StatCollector.translateToLocal(getUnlocalizedName() + ".tooltip." + i);
            if (!(getUnlocalizedName() + ".tooltip." + i).equals(tooltip))
                list.add(StatCollector.translateToLocal(getUnlocalizedName() + ".tooltip." + i));
            else break;
        }
    }
}
