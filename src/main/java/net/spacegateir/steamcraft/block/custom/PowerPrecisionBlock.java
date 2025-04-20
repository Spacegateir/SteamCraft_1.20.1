package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PowerPrecisionBlock extends Block {

    public static final IntProperty POWER = IntProperty.of("power", 0, 15);

    public PowerPrecisionBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(POWER, 0)); // Default power level is 0
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWER);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            int currentPower = state.get(POWER);
            int newPower;

            // Adjust power manually based on player interaction
            if (player.isSneaking()) {
                newPower = MathHelper.clamp(currentPower - 1, 0, 15);
            } else {
                newPower = MathHelper.clamp(currentPower + 1, 0, 15);
            }

            world.setBlockState(pos, state.with(POWER, newPower), Block.NOTIFY_ALL);

            // Send feedback to the player about the new power level
            player.sendMessage(Text.literal("Redstone power level set to: " + newPower), true);
        }

        return ActionResult.SUCCESS;
    }
}
