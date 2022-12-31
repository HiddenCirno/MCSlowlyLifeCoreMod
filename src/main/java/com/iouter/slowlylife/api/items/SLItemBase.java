package com.iouter.slowlylife.api.items;

import com.iouter.slowlylife.SlowlyLife;
import com.iouter.slowlylife.Tags;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import java.util.List;

public abstract class SLItemBase extends Item {
    public SLItemBase(String name) {
        super();
        this.setCreativeTab(SlowlyLife.creativeTabSlowlyLife);
        this.setUnlocalizedName(name);
        this.setTextureName(Tags.MODID + ":" + getUnlocalizedName());
    }
}
