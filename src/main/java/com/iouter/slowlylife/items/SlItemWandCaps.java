package com.iouter.slowlylife.items;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.wands.WandCap;
import com.iouter.slowlylife.common.Resiger;
public class SlItemWandCaps extends WandCap {
    //ResourceLocation res = new ResourceLocation("slowlylife:textures/model/test.png");

    public SlItemWandCaps(String tag, float discount, ItemStack item, int craftCost, ResourceLocation skin) {
        super(tag, discount, item, craftCost);
        setTexture(skin);
    }

    public SlItemWandCaps(String tag, float discount, List<Aspect> specialAspects, float discountSpecial, ItemStack item,
                       int craftCost, ResourceLocation skin) {
        super(tag, discount, specialAspects, discountSpecial, item, craftCost);
        setTexture(skin);
    }

}
