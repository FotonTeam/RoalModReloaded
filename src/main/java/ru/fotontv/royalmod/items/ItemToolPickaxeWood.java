package ru.fotontv.royalmod.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.fotontv.royalmod.RoyalMod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemToolPickaxeWood extends ItemPickaxe {

    public ItemToolPickaxeWood(String name) {
        super(ToolMaterial.WOOD);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(RoyalMod.CTAB);
    }

    public boolean onBlockDestroyed(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull IBlockState state, @Nonnull BlockPos pos, @Nonnull EntityLivingBase entityLiving) {
        return true;
    }

    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull IBlockState state) {
        return 1.0F;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
        return player.isCreative();
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, @Nonnull List<String> tooltip, @Nonnull ITooltipFlag flagIn) {
        tooltip.add(new TextComponentTranslation("royalmod.addblock").setStyle(new Style().setColor(TextFormatting.WHITE)).getFormattedText());
        tooltip.add(new TextComponentTranslation("royalmod.coal_ore").setStyle(new Style().setColor(TextFormatting.DARK_GRAY)).getFormattedText());
    }
}
