package com.iouter.slowlylife.common;

import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ResigerRecipe implements Runnable{
    @Override
    public void run() {
        Recipes.advRecipes.addRecipe(
            new ItemStack(Resiger.T3Circuit),
            "aba",
            "cdc",
            "aba",
            'a',
            Items.glowstone_dust,
            'b',
            Ic2Items.diamondDust,
            'c',
            Resiger.dustEmerald,
            'd',
            Ic2Items.advancedCircuit);
        Recipes.macerator.addRecipe(
            Util.getIRecipeInput(false, 1, new ItemStack[] {new ItemStack(Items.emerald)}),
            null,
            new ItemStack(Resiger.dustEmerald));
        Recipes.compressor.addRecipe(
            Util.getIRecipeInput(false, 1, new ItemStack[] {new ItemStack(Resiger.HTAlloy)}),
            null,
            new ItemStack(Resiger.PlateHTAlloy));
        Recipes.advRecipes.addRecipe(
            new ItemStack(Resiger.t3crystal),
            "aba",
            "aca",
            "aba",
            'a',
            Resiger.dustEmerald,
            'b',
            Resiger.T3Circuit,
            'c',
            Ic2Items.lapotronCrystal);
        Recipes.advRecipes.addRecipe(
            new ItemStack(Resiger.HTAlloy),
            "aaa",
            "bbb",
            "ccc",
            'a',
            Ic2Items.platelead,
            'b',
            Ic2Items.plateadviron,
            'c',
            Ic2Items.iridiumPlate);
        Recipes.advRecipes.addRecipe(
            new ItemStack(Resiger.HTMachine),
            "aca",
            "bdb",
            "aca",
            'a',
            Resiger.PlateHTAlloy,
            'b',
            Ic2Items.plateobsidian,
            'c',
            Ic2Items.platelapi,
            'd',
            Ic2Items.advancedMachine);
        Recipes.advRecipes.addRecipe(
            new ItemStack(Resiger.HFSU),
            "aca",
            "bdb",
            "aea",
            'a',
            Resiger.t3crystal,
            'b',
            Ic2Items.evTransformer,
            'c',
            Resiger.T3Circuit,
            'd',
            Ic2Items.mfsUnit,
            'e',
            Resiger.HTMachine);
        Recipes.advRecipes.addRecipe(
            new ItemStack(Resiger.ChargepadHFSU),
            "aca",
            "bdb",
            "   ",
            'a',
            Ic2Items.advancedCircuit,
            'b',
            Ic2Items.carbonPlate,
            'c',
            Blocks.light_weighted_pressure_plate,
            'd',
            Resiger.HFSU);
    }
}
