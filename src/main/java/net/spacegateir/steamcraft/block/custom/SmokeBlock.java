package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlockEntities;
import net.spacegateir.steamcraft.block.entity.SmokeBlockEntity;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;

public class SmokeBlock extends BlockWithEntity {
    public static final IntProperty MODE = IntProperty.of("mode", 1, 3);

    public SmokeBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(MODE, 1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<net.minecraft.block.Block, BlockState> builder) {
        builder.add(MODE);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SmokeBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient && type == ModBlockEntities.SMOKE_BLOCK_ENTITY
                ? (w, pos, s, be) -> SmokeBlockEntity.tick(w, pos, s, (SmokeBlockEntity) be)
                : null;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            int mode = state.get(MODE);
            int nextMode = mode == 3 ? 1 : mode + 1;
            world.setBlockState(pos, state.with(MODE, nextMode));

            String modeName = switch (nextMode) {
                case 1 -> "Low Smoke";
                case 2 -> "Medium Smoke";
                case 3 -> "High Smoke";
                default -> "Unknown";
            };

            player.sendMessage(Text.literal("Smoke Block Mode: " + modeName), true);
        }
        return ActionResult.SUCCESS;
    }
}
