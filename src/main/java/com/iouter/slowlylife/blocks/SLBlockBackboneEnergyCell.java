package com.iouter.slowlylife.blocks;

import appeng.tile.networking.TileDenseEnergyCell;
import appeng.tile.networking.TileEnergyCell;
import appeng.block.networking.BlockDenseEnergyCell;
import appeng.block.networking.BlockEnergyCell;
import java.util.EnumSet;
import java.util.List;

import appeng.core.features.AEFeature;
import appeng.util.Platform;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.iouter.slowlylife.tileentity.SLTileBackboneEnergyCell;
import com.iouter.slowlylife.common.Resiger;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

public class SLBlockBackboneEnergyCell extends BlockEnergyCell {
    public SLBlockBackboneEnergyCell(String name)
    {
        this.setTileEntity( SLTileBackboneEnergyCell.class );
        this.setFeature( EnumSet.of( AEFeature.DenseEnergyCells ) );
        this.setCreativeTab(Resiger.creativeTabSlowlyLife);
        this.setBlockName(name);
    }

    private static IIcon[] icons = new IIcon[8];
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        icons[0] = ir.registerIcon("slowlylife:energycell.backbone.0");
        icons[1] = ir.registerIcon("slowlylife:energycell.backbone.1");
        icons[2] = ir.registerIcon("slowlylife:energycell.backbone.2");
        icons[3] = ir.registerIcon("slowlylife:energycell.backbone.3");
        icons[4] = ir.registerIcon("slowlylife:energycell.backbone.4");
        icons[5] = ir.registerIcon("slowlylife:energycell.backbone.5");
        icons[6] = ir.registerIcon("slowlylife:energycell.backbone.6");
        icons[7] = ir.registerIcon("slowlylife:energycell.backbone.7");

    }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:
                return icons[0];
            case 1:
                return icons[1];
            case 2:
                return icons[2];
            case 3:
                return icons[3];
            case 4:
                return icons[4];
            case 5:
                return icons[5];
            case 6:
                return icons[6];
            case 7:
                return icons[7];
            default:
                return super.getIcon(side, meta);
        }
    }

    @Override
    public double getMaxPower()
    {
        return 200000.0 * 8.0 * 8.0;
    }
    @Override
    public void getCheckedSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> itemStacks) {
        super.getCheckedSubBlocks(item, tabs, itemStacks);
        ItemStack charged = new ItemStack(this, 1);
        NBTTagCompound tag = Platform.openNbtData(charged);
        tag.setDouble("internalCurrentPower", this.getMaxPower());
        tag.setDouble("internalMaxPower", this.getMaxPower());
        itemStacks.add(charged);
    }
}
