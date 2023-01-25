package com.iouter.slowlylife.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.block.wiring.ContainerElectricBlock;
import ic2.core.block.wiring.GuiElectricBlock;
import ic2.core.block.wiring.TileEntityElectricBlock;
import ic2.core.util.GuiTooltipHelper;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class SLGuiChargepad extends GuiElectricBlock {

    private final ContainerElectricBlock container;
    private final String armorInv;
    private final String level;
    private final String name;

    public SLGuiChargepad(ContainerElectricBlock container, String name) {
        super(container);
        this.container = container;
        this.armorInv = StatCollector.translateToLocal("ic2.EUStorage.gui.info.armor");
        this.level = StatCollector.translateToLocal("ic2.EUStorage.gui.info.level");
        this.name = StatCollector.translateToLocal(name);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        this.fontRendererObj.drawString(
                this.name, (this.xSize - this.fontRendererObj.getStringWidth(this.name)) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.armorInv, 8, this.ySize - 126 + 3, 4210752);
        this.fontRendererObj.drawString(this.level, 79, 25, 4210752);
        int e = (int) Math.min(((TileEntityElectricBlock) this.container.base).energy, (double)
                ((TileEntityElectricBlock) this.container.base).maxStorage);
        this.fontRendererObj.drawString(" " + e, 110, 35, 4210752);
        this.fontRendererObj.drawString(
                "/" + ((TileEntityElectricBlock) this.container.base).maxStorage, 110, 45, 4210752);
        String output = StatCollector.translateToLocalFormatted(
                "ic2.EUStorage.gui.info.output", ((TileEntityElectricBlock) this.container.base).output);
        this.fontRendererObj.drawString(output, 85, 60, 4210752);
        GuiTooltipHelper.drawAreaTooltip(
                par1 - this.guiLeft,
                par2 - this.guiTop,
                ((TileEntityElectricBlock) this.container.base).getredstoneMode(),
                153,
                3,
                172,
                22);
    }
}
