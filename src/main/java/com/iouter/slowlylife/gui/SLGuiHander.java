package com.iouter.slowlylife.gui;

import com.iouter.slowlylife.api.tileentity.SLTileEntityChargepadBase;
import com.iouter.slowlylife.api.tileentity.SLTileEntityElectricBase;
import com.iouter.slowlylife.container.SLContainerChargepad;
import com.iouter.slowlylife.container.SLContainerElectric;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SLGuiHander implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof SLTileEntityElectricBase)
            return new SLContainerElectric(player, (SLTileEntityElectricBase) entity);
        else if (entity instanceof SLTileEntityChargepadBase)
            return new SLContainerChargepad(player, (SLTileEntityChargepadBase) entity);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof SLTileEntityElectricBase)
            return new SLGuiElectric(
                    new SLContainerElectric(player, (SLTileEntityElectricBase) entity),
                    "tile." + ((SLTileEntityElectricBase) entity).getInventoryName() + ".name");
        else if (entity instanceof SLTileEntityChargepadBase)
            return new SLGuiChargepad(
                    new SLContainerChargepad(player, (SLTileEntityChargepadBase) entity),
                    "tile." + ((SLTileEntityChargepadBase) entity).getInventoryName() + ".name");
        return null;
    }
}
