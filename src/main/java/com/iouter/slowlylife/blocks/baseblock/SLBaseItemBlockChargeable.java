package com.iouter.slowlylife.blocks.baseblock;
import appeng.block.AEBaseItemBlockChargeable;
import net.minecraft.block.Block;
import appeng.api.config.AccessRestriction;
import appeng.api.config.PowerUnits;
import appeng.api.definitions.IBlockDefinition;
import appeng.api.implementations.items.IAEItemPowerStorage;
import appeng.core.Api;
import appeng.core.localization.GuiText;
import appeng.util.Platform;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.iouter.slowlylife.blocks.SLBlockBackboneEnergyCell;

public class SLBaseItemBlockChargeable extends AEBaseItemBlockChargeable{
    public SLBaseItemBlockChargeable(Block id) {
        super(id);
    }


}
