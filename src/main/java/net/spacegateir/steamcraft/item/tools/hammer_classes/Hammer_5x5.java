package net.spacegateir.steamcraft.item.tools.hammer_classes;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class Hammer_5x5 extends MiningToolItem {

    // Constructor
    public Hammer_5x5(ToolMaterial material, Settings settings) {
        super(5f, -1.0f, material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    // Method to get a list of blocks in a 5x5 area around the initial block
    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos initialBlockPos, ServerPlayerEntity player) {
        // Define the range; this represents how far the mining area extends from the hit block
        int rangeX = 2;  // 5 blocks wide in X direction
        int rangeY = 3;  // 3 blocks tall in Y direction (hit block in the middle Y row)
        int rangeZ = 2;  // 5 blocks wide in Z direction

        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            // If the player hits the top or bottom, break in X-Z plane (horizontal plane)
            if (blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                // We adjust the Z range to put the hit block closer to the top of the 5x5 grid
                for (int x = -rangeX; x <= rangeX; x++) {
                    for (int z = -rangeZ; z <= rangeZ; z++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + z));
                    }
                }
            }
            // If the player hits the north or south side, break in X-Y plane (vertical plane, X-Y)
            else if (blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for (int x = -rangeX; x <= rangeX; x++) {
                    for (int y = -rangeY + 2; y <= rangeY; y++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                    }
                }
            }
            // If the player hits the east or west side, break in Y-Z plane (vertical plane, Y-Z)
            else if (blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for (int z = -rangeZ; z <= rangeZ; z++) {
                    for (int y = -rangeY + 2; y <= rangeY; y++) {
                        positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + z));
                    }
                }
            }
        }

        return positions;
    }
}
