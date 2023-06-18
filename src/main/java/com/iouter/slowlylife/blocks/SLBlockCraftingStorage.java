package com.iouter.slowlylife.blocks;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.iouter.slowlylife.SlowlyLife;
import appeng.tile.crafting.TileCraftingStorageTile;
public class SLBlockCraftingStorage extends appeng.block.crafting.BlockCraftingStorage {

    private static IIcon[] icons = new IIcon[8];

    public SLBlockCraftingStorage() {
        this.setTileEntity(TileCraftingStorageTile.class);
        this.setCreativeTab(SlowlyLife.creativeTabSlowlyLife);
        this.hasSubtypes = true;
        this.setBlockName("blockCraftingStorage");
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return this.getItemUnlocalizedName(is);
    }

    protected String getItemUnlocalizedName(ItemStack is) {
        return super.getUnlocalizedName(is);
    }

    public void registerBlockIcons(IIconRegister ir) {
        icons[0] = ir.registerIcon("slowlylife:crafting.storage.256k");
        icons[1] = ir.registerIcon("slowlylife:crafting.storage.256k.fit");

        }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:
                return icons[0];
            default:
                return null;
        }
    }
}
