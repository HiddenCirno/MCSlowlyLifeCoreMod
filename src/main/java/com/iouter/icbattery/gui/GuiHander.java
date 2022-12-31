package com.iouter.icbattery.gui;

import com.iouter.icbattery.tileentity.TileEntityElectric;
import com.iouter.icbattery.container.ContainerElectric;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHander implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof TileEntityElectric)
            return new ContainerElectric(player, (TileEntityElectric) entity);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof TileEntityElectric)
            return new GuiElectric(
                    new ContainerElectric(player, (TileEntityElectric) entity),
                    "tile." + ((TileEntityElectric) entity).getInventoryName() + ".name");
        return null;
    }
}
