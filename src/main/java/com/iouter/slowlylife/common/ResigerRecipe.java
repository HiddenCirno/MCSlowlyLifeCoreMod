package com.iouter.slowlylife.common;

import appeng.items.AEBaseItem;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.registry.GameRegistry;

import appeng.api.AEApi;
import appeng.api.features.IInscriberRecipe;
import appeng.api.features.InscriberProcessType;
import appeng.core.features.registries.entries.InscriberRecipe;

import java.util.Collection;
import java.util.Collections;

public class ResigerRecipe implements Runnable{



    @Override
    public void run() {
        /*
        AEApi.instance().registries().inscriber().addRecipe( new InscriberRecipe(
            Collections.singleton(new ItemStack((Item)Item.itemRegistry.getObject("appliedenergistics2:item.ItemMultiMaterial"), 1, 14)),
            new ItemStack(Resiger.advEngProcessPress),
            new ItemStack(Resiger.BackboneGoldPlate),
            new ItemStack(Resiger.BackboneGoldPlate),
            InscriberProcessType.Press
        ) );
        */
        GameRegistry.addShapedRecipe(
            new ItemStack(Resiger.advEngProcessPress),
            "aaa",
            "bbb",
            "aaa",
            'a',
            Resiger.BackboneGoldPlate,
            'b',
            new ItemStack((Item)Item.itemRegistry.getObject("appliedenergistics2:item.ItemMultiMaterial"), 1, 14)
        );
        GameRegistry.addShapedRecipe(
            new ItemStack(Resiger.advLogProcessPress),
            "aaa",
            "bbb",
            "aaa",
            'a',
            Resiger.BackboneGoldPlate,
            'b',
            new ItemStack((Item)Item.itemRegistry.getObject("appliedenergistics2:item.ItemMultiMaterial"), 1, 15)
        );
        GameRegistry.addShapedRecipe(
            new ItemStack(Resiger.advCalProcessPress),
            "aaa",
            "bbb",
            "aaa",
            'a',
            Resiger.BackboneGoldPlate,
            'b',
            new ItemStack((Item)Item.itemRegistry.getObject("appliedenergistics2:item.ItemMultiMaterial"), 1, 13)
        );
        GameRegistry.addShapedRecipe(
            new ItemStack(Resiger.advEndProcessPress),
            "aaa",
            "bbb",
            "aaa",
            'a',
            Resiger.BackboneGoldPlate,
            'b',
            new ItemStack((Item)Item.itemRegistry.getObject("appliedenergistics2:item.ItemMultiMaterial"), 1, 19)
        );
        //压印模式下三合一, 铭刻模式下top/bottom材料不消耗
        AEApi.instance().registries().inscriber().addRecipe( new InscriberRecipe(
            Collections.singleton(new ItemStack((Item) Item.itemRegistry.getObject("emerald"), 1)),
            new ItemStack(Resiger.advEngProcess),
            new ItemStack(Resiger.advEngProcessPress),
            null,
            InscriberProcessType.Inscribe
        ) );
        AEApi.instance().registries().inscriber().addRecipe( new InscriberRecipe(
            Collections.singleton(new ItemStack((Item) Item.itemRegistry.getObject("dye"), 1, 4)),
            new ItemStack(Resiger.advLogProcess),
            new ItemStack(Resiger.advLogProcessPress),
            null,
            InscriberProcessType.Inscribe
        ) );
        AEApi.instance().registries().inscriber().addRecipe( new InscriberRecipe(
            Collections.singleton(new ItemStack((Item) Item.itemRegistry.getObject("appliedenergistics2:item.ItemMultiMaterial"), 1, 12)),
            new ItemStack(Resiger.advCalProcess),
            new ItemStack(Resiger.advCalProcessPress),
            null,
            InscriberProcessType.Inscribe
        ) );
        AEApi.instance().registries().inscriber().addRecipe( new InscriberRecipe(
            Collections.singleton(new ItemStack((Item) Item.itemRegistry.getObject("ender_pearl"), 1)),
            new ItemStack(Resiger.advEndProcess),
            new ItemStack(Resiger.advEndProcessPress),
            null,
            InscriberProcessType.Inscribe
        ) );
        AEApi.instance().registries().inscriber().addRecipe( new InscriberRecipe(
            Collections.singleton(new ItemStack((Item) Item.itemRegistry.getObject("appliedenergistics2:item.ItemMultiMaterial"), 1, 24)),
            new ItemStack(Resiger.advEngProcessBoard),
            new ItemStack(Resiger.advEngProcess),
            new ItemStack(Resiger.advEndProcess),
            InscriberProcessType.Press
        ) );
        AEApi.instance().registries().inscriber().addRecipe( new InscriberRecipe(
            Collections.singleton(new ItemStack((Item) Item.itemRegistry.getObject("appliedenergistics2:item.ItemMultiMaterial"), 1, 22)),
            new ItemStack(Resiger.advLogProcessBoard),
            new ItemStack(Resiger.advLogProcess),
            new ItemStack(Resiger.advEndProcess),
            InscriberProcessType.Press
        ) );
        AEApi.instance().registries().inscriber().addRecipe( new InscriberRecipe(
            Collections.singleton(new ItemStack((Item) Item.itemRegistry.getObject("appliedenergistics2:item.ItemMultiMaterial"), 1, 23)),
            new ItemStack(Resiger.advCalProcessBoard),
            new ItemStack(Resiger.advCalProcess),
            new ItemStack(Resiger.advEndProcess),
            InscriberProcessType.Press
        ) );
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
        Recipes.compressor.addRecipe(Util.getIRecipeInput(false, 9, new ItemStack[] { Ic2Items.denseplategold}),
            null,
            new ItemStack(Resiger.BackboneGoldPlate));
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
