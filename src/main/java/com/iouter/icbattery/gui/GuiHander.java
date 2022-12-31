package com.iouter.icbattery.gui;

import com.iouter.icbattery.container.ContainerElectric;
import com.iouter.icbattery.api.tileentity.TileEntityElectricBase;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHander implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof TileEntityElectricBase) return new ContainerElectric(player, (TileEntityElectricBase) entity);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof TileEntityElectricBase)
            return new GuiElectric(
                    new ContainerElectric(player, (TileEntityElectricBase) entity),
                    "tile." + ((TileEntityElectricBase) entity).getInventoryName() + ".name");
        return null;
    }
}
