package ru.fotontv.royalmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.server.FMLServerHandler;
import org.apache.logging.log4j.Logger;
import ru.fotontv.royalmod.commands.DelBlock;
import ru.fotontv.royalmod.commands.RegenBlock;
import ru.fotontv.royalmod.commands.StartGameMod;
import ru.fotontv.royalmod.commands.StopGameMod;
import ru.fotontv.royalmod.proxy.CommonProxy;

@Mod(modid = RoyalMod.MODID, name = RoyalMod.NAME, version = RoyalMod.VERSION, dependencies = "required-after:oxygen_shop@[0.11.0,);required-after:metamorph@[1.2.7,);")
public class RoyalMod
{
    public static final String MODID = "royalmod";
    public static final String NAME = "RoyalMod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    public static final CreativeTabs CTAB = new CreativeTabs("creativeTab") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemsRegistry.pickaxeDiamond);
        }
    };

    @SidedProxy(clientSide = "ru.fotontv.royalmod.proxy.ClientProxy", serverSide = "ru.fotontv.royalmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    @SideOnly(Side.SERVER)
    @EventHandler
    public void init(FMLServerStartingEvent event) {
        event.registerServerCommand(new RegenBlock());
        event.registerServerCommand(new DelBlock());
        event.registerServerCommand(new StartGameMod());
        event.registerServerCommand(new StopGameMod());
    }

    @SideOnly(Side.SERVER)
    @EventHandler
    public void stopServer(FMLServerStoppingEvent event)
    {
       EventsHandler.blocksSet.forEach((block, blockPos) -> {
           World world = FMLServerHandler.instance().getServer().getWorld(0);
           world.setBlockState(blockPos, block.getDefaultState());
       });
    }
}
