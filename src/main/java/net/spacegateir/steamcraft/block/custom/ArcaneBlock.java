package net.spacegateir.steamcraft.block.custom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class ArcaneBlock extends Block {
    // modify when the json file gets more models
    public static final IntProperty SWITCH_STATE = IntProperty.of("switch_state", 0, 49);


    public ArcaneBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(SWITCH_STATE, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SWITCH_STATE);
    }

}

