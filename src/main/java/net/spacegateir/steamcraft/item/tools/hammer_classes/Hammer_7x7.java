package net.spacegateir.steamcraft.item.tools.hammer_classes;

import net.minecraft.block.Blocks;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hammer_7x7 extends MiningToolItem {

    // Constructor
    public Hammer_7x7(ToolMaterial material, Settings settings) {
        super(2f, -3.0f, material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    // Method to get a list of blocks in a 7x7 area around the initial block
    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos initialBlockPos, ServerPlayerEntity player) {
        // Define the ranges; this represents how far the mining area extends from the hit block
        int miningRange = 3;  // 7 blocks wide in all directions (3 blocks on each side)
        int outerRange = 4;   // 9 blocks wide in all directions (4 blocks on each side)

        List<BlockPos> positions = new ArrayList<>();
        Set<BlockPos> outerPositions = new HashSet<>(); // For the outer area

        HitResult hit = player.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            // If the player hits the top or bottom, break in X-Z plane (horizontal plane)
            if (blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                for (int x = -miningRange; x <= miningRange; x++) {
                    for (int z = -miningRange; z <= miningRange; z++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + z));
                    }
                }
                for (int x = -outerRange; x <= outerRange; x++) {
                    for (int z = -outerRange; z <= outerRange; z++) {
                        outerPositions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + z));
                    }
                }
            }
            // If the player hits the north or south side, break in X-Y plane (vertical plane, X-Y)
            else if (blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for (int x = -miningRange; x <= miningRange; x++) {
                    for (int y = -miningRange + 2; y <= miningRange + 2; y++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                    }
                }
                for (int x = -outerRange; x <= outerRange; x++) {
                    for (int y = -outerRange + 2; y <= outerRange + 2; y++) {
                        outerPositions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                    }
                }
            }
            // If the player hits the east or west side, break in Y-Z plane (vertical plane, Y-Z)
            else if (blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for (int z = -miningRange; z <= miningRange; z++) {
                    for (int y = -miningRange + 2; y <= miningRange + 2; y++) {
                        positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + z));
                    }
                }
                for (int z = -outerRange; z <= outerRange; z++) {
                    for (int y = -outerRange + 2; y <= outerRange + 2; y++) {
                        outerPositions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + z));
                    }
                }
            }
        }

        // Now, we will replace liquid blocks with air in the mining zone
        World world = player.getWorld(); // Get the player's world
        for (BlockPos pos : positions) {
            // Check if the block at pos is a liquid (water or lava)
            if (world.getBlockState(pos).getBlock() == Blocks.WATER ||
                    world.getBlockState(pos).getBlock() == Blocks.LAVA) {
                // Set the block at this position to air
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }

        // Check the outer area for lava blocks and replace them with cobblestone
        for (BlockPos outerPos : outerPositions) {
            if (world.getBlockState(outerPos).getBlock() == Blocks.LAVA) {
                world.setBlockState(outerPos, Blocks.COBBLESTONE.getDefaultState());
            }
        }

        return positions;
    }
}
