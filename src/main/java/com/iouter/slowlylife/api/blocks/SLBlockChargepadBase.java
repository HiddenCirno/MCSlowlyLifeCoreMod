package com.iouter.slowlylife.api.blocks;

import com.iouter.slowlylife.Tags;
import com.iouter.slowlylife.api.tileentity.SLTileEntityChargepadBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.IC2;
import ic2.core.block.TileEntityBlock;
import ic2.core.block.wiring.TileEntityChargepadBlock;
import ic2.core.util.StackUtil;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class SLBlockChargepadBase extends SLBlockElectricBase {
    @SideOnly(Side.CLIENT)
    private IIcon top, back, output, input, recharge, notcharge;

    public SLBlockChargepadBase(String name, int maxOutput, int maxStorage) {
        super(name, maxOutput, maxStorage);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.95F, 1.0F);
    }

    /**
     * World only
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
        TileEntity tile = iBlockAccess.getTileEntity(x, y, z);
        if (tile instanceof TileEntityBlock) {
            switch (new Short(((TileEntityBlock) tile).getFacing()).intValue()) {
                case 0: // Up
                case 2: // South
                    switch (side) {
                        case 3:
                            return this.back;
                        case 0:
                            return this.top;
                        case 1:
                            return getChargepad(isActive(iBlockAccess, x, y, z));
                        case 2:
                            return this.output;
                        default:
                            return this.input;
                    }
                case 3: // North
                    switch (side) {
                        case 2:
                            return this.back;
                        case 0:
                            return this.top;
                        case 1:
                            return getChargepad(isActive(iBlockAccess, x, y, z));
                        case 3:
                            return this.output;
                        default:
                            return this.input;
                    }
                case 1: // Down
                case 4: // East
                    switch (side) {
                        case 5:
                            return this.back;
                        case 0:
                            return this.top;
                        case 1:
                            return getChargepad(isActive(iBlockAccess, x, y, z));
                        case 4:
                            return this.output;
                        default:
                            return this.input;
                    }
                case 5: // West
                    switch (side) {
                        case 4:
                            return this.back;
                        case 0:
                            return this.top;
                        case 1:
                            return getChargepad(isActive(iBlockAccess, x, y, z));
                        case 5:
                            return this.output;
                        default:
                            return this.input;
                    }
                default: // Unknown
                    return input;
            }
        }

        return null;
    }

    /**
     * Hand only (side- not west or east
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        switch (side) {
            case 2:
                return this.back;
            case 0:
                return this.top;
            case 1:
                return this.notcharge;
            case 3:
                return this.output;
            default:
                return this.input;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        this.top = register.registerIcon(Tags.MODID + ":" + this.getUnlocalizedName() + ".top");
        this.back = register.registerIcon(Tags.MODID + ":" + this.getUnlocalizedName() + ".back");
        this.output = register.registerIcon(Tags.MODID + ":" + this.getUnlocalizedName() + ".output");
        this.input = register.registerIcon(Tags.MODID + ":" + this.getUnlocalizedName() + ".input");
        this.recharge = register.registerIcon(Tags.MODID + ":" + this.getUnlocalizedName() + ".recharge");
        this.notcharge = register.registerIcon(Tags.MODID + ":" + this.getUnlocalizedName() + ".notcharge");
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
        if (IC2.platform.isSimulating()) {
            TileEntity te = world.getTileEntity(x, y, z);
            if (te instanceof TileEntityChargepadBlock) {
                TileEntityChargepadBlock tile = (TileEntityChargepadBlock) te;
                NBTTagCompound nbt = StackUtil.getOrCreateNbtData(itemStack);
                tile.energy = nbt.getDouble("energy");
                if (entityliving == null) {
                    ((TileEntityChargepadBlock) te).setFacing((short) 0);
                } else {
                    int yaw = MathHelper.floor_double((double) (entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
                    int pitch = Math.round(entityliving.rotationPitch);
                    if (pitch <= -65) {
                        tile.setFacing((short) 0);
                    } else {
                        switch (yaw) {
                            case 0:
                                tile.setFacing((short) 2);
                                break;
                            case 1:
                                tile.setFacing((short) 5);
                                break;
                            case 2:
                                tile.setFacing((short) 3);
                                break;
                            case 3:
                                tile.setFacing((short) 4);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof SLTileEntityChargepadBase) {
            SLTileEntityChargepadBase te = (SLTileEntityChargepadBase) tile;
            te.spawnParticles(world, x, y, z, random);
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof EntityPlayer) {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof SLTileEntityChargepadBase) {
                SLTileEntityChargepadBase te = (SLTileEntityChargepadBase) tile;
                te.playerstandsat((EntityPlayer) entity);
            }
        }
    }

    public IIcon getChargepad(boolean isActive) {
        if (isActive) return recharge;
        else return notcharge;
    }

    @Override
    public boolean isNormalCube(IBlockAccess world, int i, int j, int k) {
        return false;
    }

    public final boolean isActive(IBlockAccess blockAccess, int x, int y, int z) {
        TileEntity te = blockAccess.getTileEntity(x, y, z);
        return te instanceof TileEntityBlock && ((TileEntityBlock) te).getActive();
    }
}
