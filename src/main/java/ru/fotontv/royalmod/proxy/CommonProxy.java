package ru.fotontv.royalmod.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.fotontv.royalmod.BlocksRegister;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
        BlocksRegister.register();
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
