package net.spacegateir.steamcraft.TestTools.Tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.spacegateir.steamcraft.sound.ModSounds;

public class TestsoundItem extends Item {

    public TestsoundItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        context.getWorld().playSound(
                null, // null means all nearby players will hear it
                context.getBlockPos(),

                ModSounds.ZIPPER,

                SoundCategory.BLOCKS,
                1.0f,
                -20.0f
        );

        return ActionResult.SUCCESS;
    }
}
