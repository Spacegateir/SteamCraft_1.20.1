package net.spacegateir.steamcraft.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.tools.BedrockBreakerPickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class UnbreakableBlockMixin {

    @Inject(method = "getHardness", at = @At("HEAD"), cancellable = true)
    private void onGetHardness(BlockView world, BlockPos pos, CallbackInfoReturnable<Float> cir) {

        if (!(world instanceof World w)) return;
        BlockState state = (BlockState)(Object)this;

        // Must be holding the special pickaxe
        PlayerEntity player = w.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 6, false);
        if (player == null) return;
        if (!(player.getMainHandStack().getItem() instanceof BedrockBreakerPickaxeItem)) return;

        // Block identifier
        Identifier id = Registries.BLOCK.getId(state.getBlock());
        if (id == null) return;
        String path = id.getPath();

        // -----------------------------------------
        // 1. INACTIVE mineral: instant break
        // -----------------------------------------
        if (path.contains("mineral_deposit_inactive")) {
            cir.setReturnValue(0.0F); // instant break
            return;
        }

        // -----------------------------------------
        // 2. ACTIVE mineral: hardness 5F
        // -----------------------------------------
        if (path.contains("mineral_deposit_active")) {
            cir.setReturnValue(5.0F);
            return;
        }

        // -----------------------------------------
        // 3. Bedrock + Dungeon Wall: hardness 5F
        // -----------------------------------------
        if (state.isOf(Blocks.BEDROCK) || state.isOf(ModBlocks.DUNGEON_WALL)) {
            cir.setReturnValue(30.0F);
        }
    }
}
