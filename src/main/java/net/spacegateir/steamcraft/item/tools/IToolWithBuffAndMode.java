package net.spacegateir.steamcraft.item.tools;

import net.minecraft.entity.player.PlayerEntity;

public interface IToolWithBuffAndMode {
    boolean canActivateBuff(PlayerEntity player);
    void applyBuffAbility(PlayerEntity player);

    boolean canSwitchMode(PlayerEntity player);
    void switchMode(PlayerEntity player);
}
