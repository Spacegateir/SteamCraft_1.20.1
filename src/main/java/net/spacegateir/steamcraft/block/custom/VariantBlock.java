package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import org.jetbrains.annotations.Nullable;

public class VariantBlock extends Block {

    public static final IntProperty VARIANT = IntProperty.of("variant", 0, 3);

    public VariantBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(VARIANT, 0));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        int randomVariant = ctx.getWorld().random.nextInt(4);
        return super.getPlacementState(ctx).with(VARIANT, randomVariant);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(VARIANT);
    }
}
