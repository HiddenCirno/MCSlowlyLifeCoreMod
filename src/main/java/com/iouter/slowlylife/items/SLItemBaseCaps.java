package com.iouter.slowlylife.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import com.iouter.slowlylife.common.Resiger;
import com.iouter.slowlylife.Tags;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class SLItemBaseCaps extends Item {
    public SLItemBaseCaps() {
        this.setMaxStackSize(64);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(Resiger.creativeTabSlowlyLife);
    }
    public final String[] types = {"testmats", "testmats2"};
    public IIcon[] icon;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir) {
        icon = new IIcon[types.length];
        for (int x = 0; x < types.length; x++) this.icon[x] = ir.registerIcon("forbidden:wand_cap_" + types[x]);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs xCreativeTabs, List list) {
        for (int x = 0; x < types.length; x++) {
            list.add(new ItemStack(this, 1, x));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + types[stack.getItemDamage()];
    }

}
