package com.iouter.slowlylife.common;

import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static IRecipeInput getIRecipeInput(Boolean isMatch, int amount, ItemStack[] stacks) {
        return new IRecipeInput() {
            @Override
            public boolean matches(ItemStack itemStack) {
                return isMatch;
            }

            @Override
            public int getAmount() {
                return amount;
            }

            @Override
            public List<ItemStack> getInputs() {
                return Arrays.asList(stacks);
            }
        };
    }

    public static IRecipeInput getIRecipeInputbyOredict(Boolean isMatch, int amount, String oredict) {
        return new IRecipeInput() {
            @Override
            public boolean matches(ItemStack itemStack) {
                return isMatch;
            }

            @Override
            public int getAmount() {
                return amount;
            }

            @Override
            public List<ItemStack> getInputs() {
                return OreDictionary.getOres(oredict);
            }
        };
    }
}
