package com.iouter.slowlylife.tileentity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import appeng.tile.networking.TileDenseEnergyCell;
import appeng.tile.networking.TileEnergyCell;
public class SLTileBackboneEnergyCell extends TileDenseEnergyCell {
    public SLTileBackboneEnergyCell() throws Exception {
        setInternalMaxPowerUsingReflection(200000 * 8 * 8);
    }

    private void setInternalMaxPowerUsingReflection(double internalMaxPower) throws Exception {
        // 获取父类 TileEnergyCell 的 Class 对象
        Class<?> parentClass = TileEnergyCell.class;

        // 获取父类中的私有方法 setInternalMaxPower
        Method setInternalMaxPowerMethod = parentClass.getDeclaredMethod("setInternalMaxPower", double.class);

        // 设置私有方法可访问
        setInternalMaxPowerMethod.setAccessible(true);

        // 调用私有方法并传入参数
        setInternalMaxPowerMethod.invoke(this, internalMaxPower);
    }
}
