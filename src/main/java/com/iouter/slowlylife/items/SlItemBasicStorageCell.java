package com.iouter.slowlylife.items;

import appeng.api.AEApi;
import appeng.api.config.FuzzyMode;
import appeng.api.config.IncludeExclude;
import appeng.api.exceptions.MissingDefinition;
import appeng.api.implementations.items.IItemGroup;
import appeng.api.implementations.items.IStorageCell;
import appeng.api.implementations.items.IUpgradeModule;
import appeng.api.storage.ICellInventory;
import appeng.api.storage.ICellInventoryHandler;
import appeng.api.storage.IMEInventoryHandler;
import appeng.api.storage.ISaveProvider;
import appeng.api.storage.StorageChannel;
import appeng.api.storage.data.IAEItemStack;
import appeng.api.storage.data.IItemList;
import appeng.core.AEConfig;
import appeng.core.features.AEFeature;
import appeng.core.localization.GuiText;
import appeng.items.AEBaseItem;
import appeng.items.contents.CellConfig;
import appeng.items.contents.CellUpgrades;
import appeng.items.materials.MaterialType;
import appeng.util.InventoryAdaptor;
import appeng.util.Platform;
import com.google.common.base.Optional;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
//This class is not used now
public class SlItemBasicStorageCell extends AEBaseItem implements IStorageCell, IItemGroup{
    public MaterialType component;
    public int totalBytes;
    public int perType;
    public double idleDrain;

    public SlItemBasicStorageCell(MaterialType whichCell, int kilobytes) {
        super(Optional.of(kilobytes + "k"));
        this.setFeature(EnumSet.of(AEFeature.StorageCells));
        this.setMaxStackSize(1);
        this.totalBytes = kilobytes * 1024;
        this.component = whichCell;
        switch (this.component) {
            case Cell1kPart:
                this.idleDrain = 0.5;
                this.perType = 8;
                break;
            case Cell4kPart:
                this.idleDrain = 1.0;
                this.perType = 32;
                break;
            case Cell16kPart:
                this.idleDrain = 1.5;
                this.perType = 128;
                break;
            case Cell64kPart:
                this.idleDrain = 2.0;
                this.perType = 512;
                break;
            default:
                this.idleDrain = 0.0;
                this.perType = 8;
        }

    }

    public void addCheckedInformation(ItemStack stack, EntityPlayer player, List<String> lines, boolean displayMoreInfo) {
        IMEInventoryHandler<?> inventory = AEApi.instance().registries().cell().getCellInventory(stack, (ISaveProvider)null, StorageChannel.ITEMS);
        if (inventory instanceof ICellInventoryHandler) {
            ICellInventoryHandler handler = (ICellInventoryHandler)inventory;
            ICellInventory cellInventory = handler.getCellInv();
            if (cellInventory != null) {
                lines.add(cellInventory.getUsedBytes() + " " + GuiText.Of.getLocal() + ' ' + cellInventory.getTotalBytes() + ' ' + GuiText.BytesUsed.getLocal());
                lines.add(cellInventory.getStoredItemTypes() + " " + GuiText.Of.getLocal() + ' ' + cellInventory.getTotalItemTypes() + ' ' + GuiText.Types.getLocal());
                if (handler.isPreformatted()) {
                    String list = (handler.getIncludeExcludeMode() == IncludeExclude.WHITELIST ? GuiText.Included : GuiText.Excluded).getLocal();
                    if (handler.isFuzzy()) {
                        lines.add(GuiText.Partitioned.getLocal() + " - " + list + ' ' + GuiText.Fuzzy.getLocal());
                    } else {
                        lines.add(GuiText.Partitioned.getLocal() + " - " + list + ' ' + GuiText.Precise.getLocal());
                    }
                }
            }
        }

    }

    public int getBytes(ItemStack cellItem) {
        return this.totalBytes;
    }

    public int BytePerType(ItemStack cell) {
        return this.perType;
    }

    public int getBytesPerType(ItemStack cellItem) {
        return this.perType;
    }

    public int getTotalTypes(ItemStack cellItem) {
        return 63;
    }

    public boolean isBlackListed(ItemStack cellItem, IAEItemStack requestedAddition) {
        return false;
    }

    public boolean storableInStorageCell() {
        return false;
    }

    public boolean isStorageCell(ItemStack i) {
        return true;
    }

    public double getIdleDrain() {
        return this.idleDrain;
    }

    public String getUnlocalizedGroupName(Set<ItemStack> others, ItemStack is) {
        return GuiText.StorageCells.getUnlocalized();
    }

    public boolean isEditable(ItemStack is) {
        return true;
    }

    public IInventory getUpgradesInventory(ItemStack is) {
        return new CellUpgrades(is, 2);
    }

    public IInventory getConfigInventory(ItemStack is) {
        return new CellConfig(is);
    }

    public FuzzyMode getFuzzyMode(ItemStack is) {
        String fz = Platform.openNbtData(is).getString("FuzzyMode");

        try {
            return FuzzyMode.valueOf(fz);
        } catch (Throwable var4) {
            return FuzzyMode.IGNORE_ALL;
        }
    }

    public void setFuzzyMode(ItemStack is, FuzzyMode fzMode) {
        Platform.openNbtData(is).setString("FuzzyMode", fzMode.name());
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        this.disassembleDrive(stack, world, player);
        return stack;
    }

    private boolean disassembleDrive(ItemStack stack, World world, EntityPlayer player) {
        if (player.isSneaking()) {
            if (Platform.isClient()) {
                return false;
            }

            InventoryPlayer playerInventory = player.inventory;
            IMEInventoryHandler inv = AEApi.instance().registries().cell().getCellInventory(stack, (ISaveProvider)null, StorageChannel.ITEMS);
            if (inv != null && playerInventory.getCurrentItem() == stack) {
                InventoryAdaptor ia = InventoryAdaptor.getAdaptor(player, ForgeDirection.UNKNOWN);
                IItemList<IAEItemStack> list = inv.getAvailableItems(StorageChannel.ITEMS.createList());
                if (list.isEmpty() && ia != null) {
                    playerInventory.setInventorySlotContents(playerInventory.currentItem, (ItemStack)null);
                    ItemStack extraB = ia.addItems(this.component.stack(1));
                    if (extraB != null) {
                        player.dropPlayerItemWithRandomChoice(extraB, false);
                    }

                    IInventory upgradesInventory = this.getUpgradesInventory(stack);

                    ItemStack storageCellStack;
                    ItemStack extraA;
                    for(int upgradeIndex = 0; upgradeIndex < upgradesInventory.getSizeInventory(); ++upgradeIndex) {
                        storageCellStack = upgradesInventory.getStackInSlot(upgradeIndex);
                        extraA = ia.addItems(storageCellStack);
                        if (extraA != null && storageCellStack.getItem() instanceof IUpgradeModule) {
                            player.dropPlayerItemWithRandomChoice(storageCellStack, false);
                        }
                    }

                    Iterator i$ = AEApi.instance().definitions().materials().emptyStorageCell().maybeStack(1).asSet().iterator();

                    while(i$.hasNext()) {
                        storageCellStack = (ItemStack)i$.next();
                        extraA = ia.addItems(storageCellStack);
                        if (extraA != null) {
                            player.dropPlayerItemWithRandomChoice(extraA, false);
                        }
                    }

                    if (player.inventoryContainer != null) {
                        player.inventoryContainer.detectAndSendChanges();
                    }

                    return true;
                }
            }
        }

        return false;
    }

    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        return this.disassembleDrive(stack, world, player);
    }

    public ItemStack getContainerItem(ItemStack itemStack) {
        Iterator i$ = AEApi.instance().definitions().materials().emptyStorageCell().maybeStack(1).asSet().iterator();
        if (i$.hasNext()) {
            ItemStack stack = (ItemStack)i$.next();
            return stack;
        } else {
            throw new MissingDefinition("Tried to use empty storage cells while basic storage cells are defined.");
        }
    }

    public boolean hasContainerItem(ItemStack stack) {
        return AEConfig.instance.isFeatureEnabled(AEFeature.EnableDisassemblyCrafting);
    }


}
