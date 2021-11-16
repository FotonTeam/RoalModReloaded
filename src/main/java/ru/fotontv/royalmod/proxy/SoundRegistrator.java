package ru.fotontv.royalmod.proxy;

import austeretony.oxygen_core.common.sound.OxygenSoundEffects;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.fotontv.royalmod.RoyalMod;

@Mod.EventBusSubscriber(modid = RoyalMod.MODID)
public class SoundRegistrator {
    public static final OxygenSoundEffects.SoundEventContainer OPEN_BANK = new OxygenSoundEffects.SoundEventContainer("royalmod", "open_bank");
    public static final OxygenSoundEffects.SoundEventContainer UPDATE_ITEM = new OxygenSoundEffects.SoundEventContainer("royalmod", "update_item");

    public SoundRegistrator() {}

    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(OPEN_BANK.getSoundEvent(), UPDATE_ITEM.getSoundEvent());
    }
}
