package ru.fotontv.royalmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.fotontv.royalmod.RoyalMod;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockGoldOre extends Block {
    protected static final AxisAlignedBB BLOCK_TOP = new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 0.8F, 0.8F);

    public BlockGoldOre(String name)
    {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(RoyalMod.MODID + "." + name);
        this.setCreativeTab(RoyalMod.CTAB);
        this.setHardness(5.0F);
        this.setResistance(7.0F);
    }

    @Nonnull
    public Item getItemDropped(@Nonnull IBlockState state, @Nonnull Random rand, int fortune) {
        return Items.AIR;
    }

    @Override
    public int getExpDrop(@Nonnull IBlockState state, @Nonnull net.minecraft.world.IBlockAccess world, @Nonnull BlockPos pos, int fortune) {
        return 0;
    }


    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(@Nonnull IBlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos) {
        return BLOCK_TOP;
    }

    @SuppressWarnings("deprecation")
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(@Nonnull IBlockState state, @Nonnull IBlockAccess worldIn, @Nonnull BlockPos pos, @Nonnull EnumFacing side) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isBlockNormalCube(@Nonnull IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(@Nonnull IBlockState state) {
        return false;
    }
}
