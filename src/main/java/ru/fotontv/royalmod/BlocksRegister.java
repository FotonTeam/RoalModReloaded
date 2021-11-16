package ru.fotontv.royalmod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.fotontv.royalmod.blocks.*;

import java.util.Objects;

public class BlocksRegister {
    public static Block LAPIS_ORE = new BlockLapisOre("lapis_ore");
    public static Block GOLD_ORE = new BlockGoldOre("gold_ore");
    public static Block COAL_ORE = new BlockCoalOre("coal_ore");
    public static Block DIAMOND_ORE = new BlockDiamondOre("diamond_ore");
    public static Block EMERALD_ORE = new BlockEmeraldOre("emerald_ore");
    public static Block IRON_ORE = new BlockIronOre("iron_ore");
    public static Block REDSTONE_ORE = new BlockRedStoneOre("redstone_ore");
    public static Block BANK = new BlockBank("bank");
    public static Block BANKTWO = new BlockBankTwo("bank2");
    public static Block BARRICADE= new BlockBarricade("barricade");

    public static void register()
    {
        setRegister(LAPIS_ORE);
        setRegister(GOLD_ORE);
        setRegister(REDSTONE_ORE);
        setRegister(COAL_ORE);
        setRegister(DIAMOND_ORE);
        setRegister(EMERALD_ORE);
        setRegister(IRON_ORE);
        setRegister(BANK);
        setRegister(BANKTWO);
        setRegister(BARRICADE);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
        setRender(LAPIS_ORE);
        setRender(GOLD_ORE);
        setRender(REDSTONE_ORE);
        setRender(COAL_ORE);
        setRender(DIAMOND_ORE);
        setRender(EMERALD_ORE);
        setRender(IRON_ORE);
        setRender(BANK);
        setRender(BANKTWO);
        setRender(BARRICADE);
    }

    private static void setRegister(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
        if (block.equals(BARRICADE)) {
            ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(Objects.requireNonNull(block.getRegistryName())).setMaxStackSize(4));
        } else {
            ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(Objects.requireNonNull(block.getRegistryName())));
        }
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Block block)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
