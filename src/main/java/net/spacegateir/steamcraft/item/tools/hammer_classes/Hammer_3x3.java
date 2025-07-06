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

public class Hammer_3x3 extends MiningToolItem {

    // Constructor
    public Hammer_3x3(ToolMaterial material, Settings settings) {
        super(2f, -2.5f, material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    // Method to get a list of blocks in a 3x3 area around the initial block
    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos initialBlockPos, ServerPlayerEntity player) {
        // Define the range; this represents how far the mining area extends from the hit block
        int range = 1;  // 3 blocks wide in X and Z directions
        int height = 1; // 3 blocks tall in Y direction (hit block in the middle Y row)

        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            // If the player hits the top or bottom, break in X-Z plane (horizontal plane)
            if (blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                // Loop through a 3x3 area centered on the hit block
                for (int x = -range; x <= range; x++) {
                    for (int z = -range; z <= range; z++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + z));
                    }
                }
            }
            // If the player hits the north or south side, break in Y-Z plane (vertical plane)
            else if (blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for (int x = -range; x <= range; x++) {
                    for (int y = -height; y <= height; y++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                    }
                }
            }
            // If the player hits the east or west side, break in X-Y plane (vertical plane)
            else if (blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for (int z = -range; z <= range; z++) {
                    for (int y = -height; y <= height; y++) {
                        positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + z));
                    }
                }
            }
        }

        return positions;
    }


}
