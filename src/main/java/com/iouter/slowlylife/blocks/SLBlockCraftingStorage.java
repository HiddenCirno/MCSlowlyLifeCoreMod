    package com.iouter.slowlylife.blocks;

    import appeng.block.crafting.BlockCraftingStorage;
    import com.iouter.slowlylife.common.Resiger;
    import cpw.mods.fml.relauncher.Side;
    import cpw.mods.fml.relauncher.SideOnly;
    import ic2.api.item.ElectricItem;
    import net.minecraft.client.renderer.texture.IIconRegister;
    import net.minecraft.entity.player.EntityPlayer;
    import net.minecraft.item.ItemStack;
    import net.minecraft.util.IIcon;
    import java.util.EnumSet;
    import appeng.core.features.AEFeature;
    import net.minecraft.creativetab.CreativeTabs;
    import com.iouter.slowlylife.tileentity.SLTileEntityCraftingStorage;
    import net.minecraft.item.Item;
    import net.minecraft.util.StatCollector;

    import java.util.List;

    public class SLBlockCraftingStorage extends BlockCraftingStorage {

        private static IIcon[] icons = new IIcon[8];

        public SLBlockCraftingStorage(String name) {
            this.setTileEntity(SLTileEntityCraftingStorage.class);
            this.setCreativeTab(Resiger.creativeTabSlowlyLife);
            this.hasSubtypes = true;
            this.setFeature( EnumSet.of( AEFeature.CraftingCPU ) );
            this.setBlockName(name);
        }

        @Override
        public String getUnlocalizedName(ItemStack stack) {
            int meta = stack.getItemDamage();
            switch (meta) {
                case 0:
                    return "tile.sl.BlockCraftingStorage64m";
                case 1:
                    return "tile.sl.BlockCraftingStorage256m";
                case 2:
                    return "tile.sl.BlockCraftingStorage1g";
                case 3:
                    return "tile.sl.BlockCraftingStorage4g";
                default:
                    return super.getUnlocalizedName(stack);
            }
        }



        @SideOnly(Side.CLIENT)
        public void registerBlockIcons(IIconRegister ir) {
            icons[0] = ir.registerIcon("slowlylife:crafting.storage.65536k");
            icons[1] = ir.registerIcon("slowlylife:crafting.storage.65536k.fit");
            icons[2] = ir.registerIcon("slowlylife:crafting.storage.262144k");
            icons[3] = ir.registerIcon("slowlylife:crafting.storage.262144k.fit");
            icons[4] = ir.registerIcon("slowlylife:crafting.storage.1048576k");
            icons[5] = ir.registerIcon("slowlylife:crafting.storage.1048576k.fit");
            icons[6] = ir.registerIcon("slowlylife:crafting.storage.4194304k");
            icons[7] = ir.registerIcon("slowlylife:crafting.storage.4194304k.fit");

            }

        @SideOnly(Side.CLIENT)
        @Override
        public IIcon getIcon(int side, int meta) {
            switch (meta & (~4)) {
                case 0:
                    return icons[0];
                case 1:
                    return icons[2];
                case 2:
                    return icons[4];
                case 3:
                    return icons[6];
                case 8:
                    return icons[1];
                case 1 | 8:
                    return icons[3];
                case 2 | 8:
                    return icons[5];
                case 3 | 8:
                    return icons[7];
                default:
                    return null;
            }
        }

        //creative item
        @Override
        public void getCheckedSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> itemStacks) {
            itemStacks.add(new ItemStack(this, 1, 0));
            itemStacks.add(new ItemStack(this, 1, 1));
            itemStacks.add(new ItemStack(this, 1, 2));
            itemStacks.add(new ItemStack(this, 1, 3));
        }
    }
