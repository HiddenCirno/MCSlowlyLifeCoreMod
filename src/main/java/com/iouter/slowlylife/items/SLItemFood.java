package com.iouter.slowlylife.items;

import com.iouter.slowlylife.SlowlyLife;
import com.iouter.slowlylife.Tags;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class SLItemFood extends net.minecraft.item.ItemFood {
    public SLItemFood(String name, int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
        this.setCreativeTab(SlowlyLife.creativeTabSlowlyLife);
        this.setUnlocalizedName(name);
        this.setTextureName(Tags.MODID + ":" + getUnlocalizedName());
    }

    public SLItemFood(String name, int p_i45340_1_, boolean p_i45340_2_) {
        this(name, p_i45340_1_, 0.6f, p_i45340_2_);
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
