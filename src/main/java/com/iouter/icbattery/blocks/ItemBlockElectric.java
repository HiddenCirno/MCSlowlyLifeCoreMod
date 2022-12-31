package com.iouter.icbattery.blocks;

import com.iouter.icbattery.api.blocks.BlockElectricBase;
import com.iouter.icbattery.api.blocks.ItemBlockBasic;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockElectric extends ItemBlockBasic {

    public ItemBlockElectric(Block block) {
        super(block);
    }

    public int getMaxOutput() {
        if (this.field_150939_a instanceof BlockElectricBase) {
            return ((BlockElectricBase) field_150939_a).getMaxOutput();
        } else return 0;
    }

    public int getMaxStorage() {
        if (this.field_150939_a instanceof BlockElectricBase) {
            return ((BlockElectricBase) field_150939_a).getMaxStorage();
        } else return 0;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        final int stored;
        if (stack.hasTagCompound()) stored = stack.getTagCompound().getInteger("energy");
        else stored = 0;

        list.add(StatCollector.translateToLocalFormatted("itemBlockElectric.tooltip.0", getMaxOutput()));
        list.add(StatCollector.translateToLocalFormatted("itemBlockElectric.tooltip.1", stored, getMaxStorage()));
    }
}
