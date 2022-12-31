package com.iouter.icbattery.items;

import com.iouter.icbattery.Tags;
import com.iouter.icbattery.api.items.ItemBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

public class ItemBattery extends ItemBase implements IElectricItem {

    private final int tier;
    private final int maxCharge;
    private final int transferLimit;
    private final int maxTextureInteger;
    private IIcon[] textures;

    public ItemBattery(String name, int tier, int maxCharge, int transferLimit, int maxTextureInteger) {
        super();
        setUnlocalizedName(name);
        this.tier = tier;
        this.maxCharge = maxCharge;
        this.transferLimit = transferLimit;
        this.maxTextureInteger = maxTextureInteger;
        this.setMaxDamage(100);
        this.setMaxStackSize(1);
        this.setNoRepair();
    }

    public String getTextureName(int index) {
        return index < maxTextureInteger ? this.getUnlocalizedName() + "." + index : null;
    }

    public String getTextureFolder() {
        return "batteries";
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.textures = new IIcon[maxTextureInteger];
        String textureFolder = this.getTextureFolder() == null ? "" : this.getTextureFolder() + "/";

        for (int index = 0; index < maxTextureInteger; ++index) {
            this.textures[index] =
                    iconRegister.registerIcon(Tags.MODID + ":" + textureFolder + this.getTextureName(index));
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        int index =
                (int) Math.ceil((double) (this.getMaxDamage() - meta) * this.textures.length / this.getMaxDamage()) - 1;
        if (index < this.textures.length) {
            return this.textures[index];
        } else {
            return this.textures.length < 1 ? null : this.textures[0];
        }
    }

    @Override
    public boolean canProvideEnergy(ItemStack itemStack) {
        return true;
    }

    @Override
    public Item getChargedItem(ItemStack itemStack) {
        return this;
    }

    @Override
    public Item getEmptyItem(ItemStack itemStack) {
        return this;
    }

    @Override
    public double getMaxCharge(ItemStack itemStack) {
        return maxCharge;
    }

    @Override
    public int getTier(ItemStack itemStack) {
        return tier;
    }

    @Override
    public double getTransferLimit(ItemStack itemStack) {
        return transferLimit;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean isF3) {
        list.add(StatCollector.translateToLocalFormatted("itemBattery.tooltip.0", tier));
        list.add((StatCollector.translateToLocalFormatted(
                "itemBattery.tooltip.1", (int) ElectricItem.manager.getCharge(itemStack), (int)
                        getMaxCharge(itemStack))));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List itemList) {
        ItemStack itemStack = new ItemStack(this, 1);
        ItemStack charged;
        if (this.getChargedItem(itemStack) == this) {
            charged = new ItemStack(this, 1);
            ElectricItem.manager.charge(charged, 1.0D / 0.0, 2147483647, true, false);
            itemList.add(charged);
        }

        if (this.getEmptyItem(itemStack) == this) {
            charged = new ItemStack(this, 1);
            ElectricItem.manager.charge(charged, 0.0D, 2147483647, true, false);
            itemList.add(charged);
        }
    }
}
