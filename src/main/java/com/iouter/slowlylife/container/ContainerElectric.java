package com.iouter.slowlylife.container;

import com.iouter.slowlylife.api.tileentity.TileEntityElectricBase;
import ic2.core.ContainerFullInv;
import ic2.core.slot.SlotArmor;
import ic2.core.slot.SlotInvSlot;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerElectric extends ContainerFullInv<TileEntityElectricBase> {
    public ContainerElectric(EntityPlayer player, TileEntityElectricBase tileentity) {
        super(player, tileentity, 179, 166);
        for (int i = 0; i < 4; i++) addSlotToContainer(new SlotArmor(player.inventory, i, 152, 5 + i * 18));

        addSlotToContainer(new SlotInvSlot(tileentity.chargeSlot, 0, 128, 14));
        addSlotToContainer(new SlotInvSlot(tileentity.dischargeSlot, 0, 128, 50));
    }

    @Override
    public List<String> getNetworkedFields() {
        List<String> list = super.getNetworkedFields();
        list.add("energy");
        list.add("redstoneMode");
        return list;
    }
}
