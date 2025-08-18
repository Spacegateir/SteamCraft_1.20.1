package net.spacegateir.steamcraft.util;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public class MineralShapes {
    public static class ShapePair {
        public final VoxelShape lower;
        public final VoxelShape upper;

        public ShapePair(VoxelShape lower, VoxelShape upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    public static final Map<MineralType, ShapePair> SHAPES = new EnumMap<>(MineralType.class);

    static {
        VoxelShape fullLower = VoxelShapes.cuboid(0, 0, 0, 1, 1, 1);
        VoxelShape fullUpper = VoxelShapes.cuboid(0, 0, 0, 1, 1, 1);

        VoxelShape DefaultLower = Stream.of(
                VoxelShapes.cuboid(1 / 16.0, 0, 1 / 16.0, 15 / 16.0, 4 / 16.0, 15 / 16.0),
                VoxelShapes.cuboid(8 / 16.0, 0, 1 / 16.0, 15 / 16.0, 6 / 16.0, 12 / 16.0),
                VoxelShapes.cuboid(2 / 16.0, 4 / 16.0, 7 / 16.0, 9 / 16.0, 8 / 16.0, 14 / 16.0),
                VoxelShapes.cuboid(4 / 16.0, 4 / 16.0, 4 / 16.0, 12 / 16.0, 16 / 16.0, 12 / 16.0),
                VoxelShapes.cuboid(12 / 16.0, 4 / 16.0, 6 / 16.0, 14 / 16.0, 16 / 16.0, 10 / 16.0),
                VoxelShapes.cuboid(3 / 16.0, 11 / 16.0, 9 / 16.0, 7 / 16.0, 16 / 16.0, 13 / 16.0),
                VoxelShapes.cuboid(6 / 16.0, 8 / 16.0, 2 / 16.0, 11 / 16.0, 16 / 16.0, 4 / 16.0),
                VoxelShapes.cuboid(8 / 16.0, 4 / 16.0, 12 / 16.0, 11 / 16.0, 16 / 16.0, 13 / 16.0)
        ).reduce(VoxelShapes::union).get();

        VoxelShape DefaultUpper = Stream.of(
                VoxelShapes.cuboid(3 / 16.0, 0, 9 / 16.0, 7 / 16.0, 2 / 16.0, 13 / 16.0),
                VoxelShapes.cuboid(3 / 16.0, 1 / 16.0, 3 / 16.0, 7 / 16.0, 6 / 16.0, 7 / 16.0),
                VoxelShapes.cuboid(4 / 16.0, 0, 4 / 16.0, 12 / 16.0, 4 / 16.0, 12 / 16.0),
                VoxelShapes.cuboid(5 / 16.0, 4 / 16.0, 6 / 16.0, 10 / 16.0, 8 / 16.0, 11 / 16.0),
                VoxelShapes.cuboid(6 / 16.0, 8 / 16.0, 7 / 16.0, 8 / 16.0, 12 / 16.0, 9 / 16.0),
                VoxelShapes.cuboid(7 / 16.0, 0, 2 / 16.0, 9 / 16.0, 7 / 16.0, 6 / 16.0),
                VoxelShapes.cuboid(8 / 16.0, 0, 9 / 16.0, 11 / 16.0, 6 / 16.0, 13 / 16.0),
                VoxelShapes.cuboid(12 / 16.0, 0, 6 / 16.0, 14 / 16.0, 2 / 16.0, 10 / 16.0),
                VoxelShapes.cuboid(6 / 16.0, 0, 2 / 16.0, 11 / 16.0, 2 / 16.0, 4 / 16.0)
        ).reduce(VoxelShapes::union).get();

        SHAPES.put(MineralType.DEFAULT, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.CLAY, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.COAL, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.IRON, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.COPPER, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.SILVER, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.REDSTONE, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.LAPIS, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.GOLD, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.NETHERITE, new ShapePair(DefaultLower, DefaultUpper));
        SHAPES.put(MineralType.GEM, new ShapePair(DefaultLower, DefaultUpper));


        // Fallback for any not explicitly defined
        for (MineralType type : MineralType.values()) {
            SHAPES.putIfAbsent(type, new ShapePair(fullLower, fullUpper));
        }
    }
}
