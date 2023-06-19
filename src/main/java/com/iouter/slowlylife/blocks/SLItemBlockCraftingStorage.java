package com.iouter.slowlylife.blocks;

import appeng.block.AEBaseItemBlock;
import appeng.block.crafting.ItemCraftingStorage;
import com.iouter.slowlylife.tileentity.SLTileEntityCraftingStorage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class SLItemBlockCraftingStorage extends ItemCraftingStorage {

    public SLItemBlockCraftingStorage(final Block block){
        super(block);
    };

    @SideOnly(Side.CLIENT)
    @Override
    public void addCheckedInformation(ItemStack is, EntityPlayer player, List<String> lines, boolean isF3) {

        for (int i = 0; ; i++) {
            String tooltip = StatCollector.translateToLocal(getUnlocalizedName(is) + ".tooltip." + i);
            if (!(getUnlocalizedName(is) + ".tooltip." + i).equals(tooltip))
                lines.add(StatCollector.translateToLocal(getUnlocalizedName(is) + ".tooltip." + i));
            else break;
        }


        //SLTileEntityCraftingStorage tileEntity = (SLTileEntityCraftingStorage) is
        //int storage = tileEntity.getStorageBytes();
        //lines.add(StatCollector.translateToLocal("tooltip.storage") + ": " + storage);

        //int storage = (SLTileEntityCraftingStorage is).

        //lines.add(StatCollector.translateToLocal(SLTileEntityCraftingStorage));
    }
}
