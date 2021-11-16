package ru.fotontv.royalmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import ru.fotontv.royalmod.RoyalMod;

import javax.annotation.Nonnull;

public class ItemFryingBlue extends ItemArmor {
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial("royalmod:frying_pan_blue", "royalmod:frying_pan_blue", 9, new int[]{2, 4, 6, 3}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F).setRepairItem(new ItemStack(Item.getItemFromBlock(Blocks.OBSIDIAN)));

    public ItemFryingBlue(String name) {
        super(ARMOR_MATERIAL, 8, EntityEquipmentSlot.HEAD);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(RoyalMod.CTAB);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean onDroppedByPlayer(@Nonnull ItemStack item, EntityPlayer player) {
        return player.isCreative();
    }
}
