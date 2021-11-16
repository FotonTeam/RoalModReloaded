package ru.fotontv.royalmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import ru.fotontv.royalmod.RoyalMod;

import javax.annotation.Nonnull;

public class ItemFryingRed extends ItemArmor {

    public ItemFryingRed(String name) {
        super(ItemArmor.ArmorMaterial.DIAMOND, 6, EntityEquipmentSlot.HEAD);
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
