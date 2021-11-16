package ru.fotontv.royalmod;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.fotontv.royalmod.items.*;

@GameRegistry.ObjectHolder("royalmod")
@Mod.EventBusSubscriber
public class ItemsRegistry {

    @GameRegistry.ObjectHolder("pickaxe_diamond")
    public static final Item pickaxeDiamond = null;
    @GameRegistry.ObjectHolder("pickaxe_iron")
    public static final Item pickaxeIron = null;
    @GameRegistry.ObjectHolder("pickaxe_wood")
    public static final Item pickaxeWood = null;
    @GameRegistry.ObjectHolder("pickaxe_stone")
    public static final Item pickaxeStone = null;
    @GameRegistry.ObjectHolder("heal_item_one")
    public static final Item healItemOne = null;
    @GameRegistry.ObjectHolder("heal_item_two")
    public static final Item healItemTwo = null;
    @GameRegistry.ObjectHolder("frying_pan_blue")
    public static final Item itemFryingBlue = null;
    @GameRegistry.ObjectHolder("frying_pan_green")
    public static final Item itemFryingGreen = null;
    @GameRegistry.ObjectHolder("frying_pan_red")
    public static final Item itemFryingRed = null;
    @GameRegistry.ObjectHolder("frying_pan_yellow")
    public static final Item itemFryingYellow = null;

    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        e.getRegistry().register(new ItemToolPickaxeDiamond("pickaxe_diamond"));
        e.getRegistry().register(new ItemToolPickaxeIron("pickaxe_iron"));
        e.getRegistry().register(new ItemToolPickaxeWood("pickaxe_wood"));
        e.getRegistry().register(new ItemToolPickaxeStone("pickaxe_stone"));
        e.getRegistry().register(new ItemHealOne("heal_item_one"));
        e.getRegistry().register(new ItemHealTwo("heal_item_two"));
        e.getRegistry().register(new ItemFryingBlue("frying_pan_blue"));
        e.getRegistry().register(new ItemFryingGreen("frying_pan_green"));
        e.getRegistry().register(new ItemFryingRed("frying_pan_red"));
        e.getRegistry().register(new ItemFryingYellow("frying_pan_yellow"));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        registryModel(pickaxeDiamond);
        registryModel(pickaxeIron);
        registryModel(pickaxeWood);
        registryModel(pickaxeStone);
        registryModel(healItemOne);
        registryModel(healItemTwo);
        registryModel(itemFryingBlue);
        registryModel(itemFryingGreen);
        registryModel(itemFryingRed);
        registryModel(itemFryingYellow);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item) {
        final ResourceLocation regName = item.getRegistryName();
        final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
        ModelBakery.registerItemVariants(item, mrl);
        ModelLoader.setCustomModelResourceLocation(item, 0, mrl);
    }
}
