package com.iouter.slowlylife.blocks;

import com.iouter.slowlylife.common.Resiger;
import com.iouter.slowlylife.api.blocks.SLItemBlockBase;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class SLItemBlockCommon extends SLItemBlockBase {
    public SLItemBlockCommon(Block block) {
        super(block);
        this.setCreativeTab(Resiger.creativeTabSlowlyLife);
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
