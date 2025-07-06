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

public class Hammer_1x2 extends MiningToolItem {

    // Constructor
    public Hammer_1x2(ToolMaterial material, Settings settings) {
        super(2f, -2.5f, material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    // Method to get a list of blocks to be destroyed
    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos initialBlockPos, ServerPlayerEntity player) {
        // Define the ranges; this represents how far the mining area extends from the hit block
        int rangeX = 0; // Horizontal range for N/S and E/W (0 block)
        int rangeZ = 0; // Horizontal range for N/S and E/W (0 block)
        int rangeY = 1; // Vertical range for 1x2 area (1 block above and 1 block below)
        int rangeY3x3 = 1; // Vertical range for the 3x3 area (1 block above and 1 block below)

        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            // If the player hits the top or bottom, break in the X-Z plane (3x3 area)
            if (blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                for (int x = -1; x <= 1; x++) {  // 3x3 area
                    for (int z = -1; z <= 1; z++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + z));
                    }
                }
            }
            // If the player hits the north or south side, break in the X-Y plane (1x2 area)
            else if (blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for (int y = -rangeY; y <= rangeY - 1; y++) { // Vertical area (1 block above and 1 block below)
                    positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ()));
                }
            }
            // If the player hits the east or west side, break in the Y-Z plane (1x2 area)
            else if (blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for (int y = -rangeY; y <= rangeY - 1; y++) { // Vertical area (1 block above and 1 block below)
                    positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ()));
                }
            }
        }

        return positions;
    }


}