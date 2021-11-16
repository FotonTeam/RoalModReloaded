package ru.fotontv.royalmod.blocks;

import austeretony.oxygen_core.client.api.SoundEventHelperClient;
import austeretony.oxygen_shop.client.ShopMenuManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.fotontv.royalmod.RoyalMod;
import ru.fotontv.royalmod.proxy.SoundRegistrator;
import ru.fotontv.royalmod.util.GuiTask;

import javax.annotation.Nonnull;
import java.util.Timer;
import java.util.TimerTask;

public class BlockBank extends Block {
    protected static final AxisAlignedBB BLOCK_TOP = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockBank(String name) {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(RoyalMod.MODID + "." + name);
        this.setCreativeTab(RoyalMod.CTAB);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
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
    public boolean isOpaqueCube(@Nonnull IBlockState state)
    {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube(@Nonnull IBlockState state)
    {
        return false;
    }

    @Nonnull
    @Override
    protected net.minecraft.block.state.BlockStateContainer createBlockState() {
        return new net.minecraft.block.state.BlockStateContainer(this, FACING);
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public IBlockState getStateForPlacement(@Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
                                            EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean onBlockActivated(@Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull IBlockState state, @Nonnull EntityPlayer playerIn, @Nonnull EnumHand hand, @Nonnull EnumFacing facing, float hitX, float hitY, float hitZ) {
        SoundEventHelperClient.playSoundClient(SoundRegistrator.OPEN_BANK.getSoundEvent());
        TimerTask timerTask = new GuiTask(1);
        Timer timer = new Timer(true);
        timer.schedule(timerTask, 2*1000);
        return true;
    }
}
