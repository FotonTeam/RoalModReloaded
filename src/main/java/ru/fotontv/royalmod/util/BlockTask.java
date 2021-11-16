package ru.fotontv.royalmod.util;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.TimerTask;

public class BlockTask extends TimerTask {

    private final Block block;
    private final World world;
    private final BlockPos pos;

    public BlockTask(Block block, World world, BlockPos pos) {
        this.block = block;
        this.world = world;
        this.pos = pos;
    }

    @Override
    public void run() {
        completeTask();
    }

    private void completeTask() {
        world.setBlockState(pos, block.getDefaultState());
    }
}
