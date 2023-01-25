package com.iouter.slowlylife.container;

import com.iouter.slowlylife.api.tileentity.SLTileEntityChargepadBase;
import ic2.core.block.wiring.ContainerElectricBlock;
import net.minecraft.entity.player.EntityPlayer;

public class SLContainerChargepad extends ContainerElectricBlock {
    public SLContainerChargepad(EntityPlayer player, SLTileEntityChargepadBase tileentity) {
        super(player, tileentity);
    }
}
