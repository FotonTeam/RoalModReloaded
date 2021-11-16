package ru.fotontv.royalmod;

import austeretony.oxygen_core.common.api.CommonReference;
import austeretony.oxygen_core.server.api.CurrencyHelperServer;
import austeretony.oxygen_core.server.api.SoundEventHelperServer;
import mchorse.metamorph.api.MorphAPI;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.fotontv.royalmod.items.ItemToolPickaxeIron;
import ru.fotontv.royalmod.items.ItemToolPickaxeStone;
import ru.fotontv.royalmod.items.ItemToolPickaxeWood;
import ru.fotontv.royalmod.proxy.SoundRegistrator;
import ru.fotontv.royalmod.util.BlockTask;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Mod.EventBusSubscriber
public class EventsHandler {
    public static final Map<EntityPlayer, Integer> breaksBlock = new HashMap<>();
    public static final Map<Block, BlockPos> blocksSet = new HashMap<>();
    public static final List<BlockPos> blocksBarricadeSet = new CopyOnWriteArrayList<>();
    private static Item pickage = ItemsRegistry.pickaxeWood;
    //FMLClientHandler.instance().getServer().getWorld(0).setBlockState(BBlocksRegister.COAL_ORE.getBlockState())

    @SideOnly(Side.SERVER)
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onJoinPlayer(PlayerEvent.PlayerLoggedInEvent e) {
        EntityPlayerMP playerMP = (EntityPlayerMP) e.player;
        CurrencyHelperServer.setCurrency(playerMP.getPersistentID(), playerMP.experienceLevel, 0);
    }

    @SubscribeEvent
    public static void onPlaceBlock(BlockEvent.PlaceEvent e) {
        if (e.getPlayer().isCreative()) {
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.COAL_ORE))  {
                Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
                blocksSet.put(block, e.getPos());
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.LAPIS_ORE)) {
                Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
                blocksSet.put(block, e.getPos());
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.DIAMOND_ORE)) {
                Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
                blocksSet.put(block, e.getPos());
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.EMERALD_ORE)) {
                Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
                blocksSet.put(block, e.getPos());
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.GOLD_ORE)) {
                Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
                blocksSet.put(block, e.getPos());
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.IRON_ORE)) {
                Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
                blocksSet.put(block, e.getPos());
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.REDSTONE_ORE)) {
                Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
                blocksSet.put(block, e.getPos());
            }
        } else {
            if (!e.getPlayer().isSpectator()) {
                if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(Blocks.CHEST)) {
                    blocksBarricadeSet.add(e.getPos());
                    e.setCanceled(false);
                    return;
                }
                if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.BARRICADE)) {
                    blocksBarricadeSet.add(e.getPos());
                    e.setCanceled(false);
                    return;
                }
            }
            e.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent e) {
        EntityPlayerMP playerMP = (EntityPlayerMP) e.getPlayer();
        if (playerMP.isCreative()) {
            Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
            blocksSet.remove(block);
        } else {
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.COAL_ORE))  {
                playerMP.addExperienceLevel(1);
                playerMP.sendMessage(new TextComponentTranslation("roalmod.xp.1").setStyle(new Style().setColor(TextFormatting.GREEN)));
                CurrencyHelperServer.setCurrency(CommonReference.getPersistentUUID(playerMP), playerMP.experienceLevel, 0);
                TimerTask timerTask = new BlockTask(BlocksRegister.COAL_ORE, e.getWorld(), e.getPos());
                Timer timer = new Timer(true);
                timer.schedule(timerTask, 10*1000);
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.LAPIS_ORE)) {
                playerMP.addExperienceLevel(5);
                playerMP.sendMessage(new TextComponentTranslation("roalmod.xp.5").setStyle(new Style().setColor(TextFormatting.GREEN)));
                CurrencyHelperServer.setCurrency(CommonReference.getPersistentUUID(playerMP), playerMP.experienceLevel, 0);
                TimerTask timerTask = new BlockTask(BlocksRegister.LAPIS_ORE, e.getWorld(), e.getPos());
                Timer timer = new Timer(true);
                timer.schedule(timerTask, 20*1000);
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.DIAMOND_ORE)) {
                playerMP.addExperienceLevel(20);
                playerMP.sendMessage(new TextComponentTranslation("roalmod.xp.20").setStyle(new Style().setColor(TextFormatting.GREEN)));
                CurrencyHelperServer.setCurrency(CommonReference.getPersistentUUID(playerMP), playerMP.experienceLevel, 0);
                TimerTask timerTask = new BlockTask(BlocksRegister.DIAMOND_ORE, e.getWorld(), e.getPos());
                Timer timer = new Timer(true);
                timer.schedule(timerTask, 40*1000);
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.EMERALD_ORE)) {
                playerMP.addExperienceLevel(50);
                playerMP.sendMessage(new TextComponentTranslation("roalmod.xp.50").setStyle(new Style().setColor(TextFormatting.GREEN)));
                CurrencyHelperServer.setCurrency(CommonReference.getPersistentUUID(playerMP), playerMP.experienceLevel, 0);
                TimerTask timerTask = new BlockTask(BlocksRegister.EMERALD_ORE, e.getWorld(), e.getPos());
                Timer timer = new Timer(true);
                timer.schedule(timerTask, 60*1000);
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.GOLD_ORE)) {
                playerMP.addExperienceLevel(10);
                playerMP.sendMessage(new TextComponentTranslation("roalmod.xp.10").setStyle(new Style().setColor(TextFormatting.GREEN)));
                CurrencyHelperServer.setCurrency(CommonReference.getPersistentUUID(playerMP), playerMP.experienceLevel, 0);
                TimerTask timerTask = new BlockTask(BlocksRegister.GOLD_ORE, e.getWorld(), e.getPos());
                Timer timer = new Timer(true);
                timer.schedule(timerTask, 30*1000);
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.IRON_ORE)) {
                playerMP.addExperienceLevel(3);
                playerMP.sendMessage(new TextComponentTranslation("roalmod.xp.3").setStyle(new Style().setColor(TextFormatting.GREEN)));
                CurrencyHelperServer.setCurrency(CommonReference.getPersistentUUID(playerMP), playerMP.experienceLevel, 0);
                TimerTask timerTask = new BlockTask(BlocksRegister.IRON_ORE, e.getWorld(), e.getPos());
                Timer timer = new Timer(true);
                timer.schedule(timerTask, 15*1000);
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.REDSTONE_ORE)) {
                playerMP.addExperienceLevel(7);
                playerMP.sendMessage(new TextComponentTranslation("roalmod.xp.7").setStyle(new Style().setColor(TextFormatting.GREEN)));
                CurrencyHelperServer.setCurrency(CommonReference.getPersistentUUID(playerMP), playerMP.experienceLevel, 0);
                TimerTask timerTask = new BlockTask(BlocksRegister.REDSTONE_ORE, e.getWorld(), e.getPos());
                Timer timer = new Timer(true);
                timer.schedule(timerTask, 25*1000);
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.BARRICADE)) {
                blocksBarricadeSet.remove(e.getPos());
            }
            if (breaksBlock.containsKey(playerMP)) {
                int oldStat = breaksBlock.get(playerMP);
                breaksBlock.replace(playerMP, oldStat + 1);
                if ((oldStat + 1) == 25) {
                    for (ItemStack stack : playerMP.inventory.mainInventory) {
                        if (stack.getItem() instanceof ItemToolPickaxeWood) {
                            SoundEventHelperServer.playSoundClient(playerMP, SoundRegistrator.UPDATE_ITEM.getId());
                            playerMP.inventory.mainInventory.set(playerMP.inventory.currentItem, new ItemStack(ItemsRegistry.pickaxeStone));
                        }
                    }
                }
                if ((oldStat + 1) == 50) {
                    for (ItemStack stack : playerMP.inventory.mainInventory) {
                        if (stack.getItem() instanceof ItemToolPickaxeStone) {
                            SoundEventHelperServer.playSoundClient(playerMP, SoundRegistrator.UPDATE_ITEM.getId());
                            playerMP.inventory.mainInventory.set(playerMP.inventory.currentItem, new ItemStack(ItemsRegistry.pickaxeIron));
                        }
                    }
                }
                if ((oldStat + 1) == 100) {
                    for (ItemStack stack : playerMP.inventory.mainInventory) {
                        if (stack.getItem() instanceof ItemToolPickaxeIron) {
                            SoundEventHelperServer.playSoundClient(playerMP, SoundRegistrator.UPDATE_ITEM.getId());
                            playerMP.inventory.mainInventory.set(playerMP.inventory.currentItem, new ItemStack(ItemsRegistry.pickaxeDiamond));
                        }
                    }
                }
                if ((oldStat + 1) < 100) {
                    for (ItemStack stack : playerMP.inventory.mainInventory) {
                        if (stack.getItem() instanceof ItemToolPickaxeWood) {
                            playerMP.sendMessage(new TextComponentTranslation("royalmod.breakblocks").appendText(" (").appendText(String.valueOf(oldStat + 1)).appendText("/25)").setStyle(new Style().setColor(TextFormatting.GREEN)));
                        }
                        if (stack.getItem() instanceof ItemToolPickaxeStone) {
                            playerMP.sendMessage(new TextComponentTranslation("royalmod.breakblocks").appendText(" (").appendText(String.valueOf(oldStat + 1)).appendText("/50)").setStyle(new Style().setColor(TextFormatting.GREEN)));
                        }
                        if (stack.getItem() instanceof ItemToolPickaxeIron) {
                            playerMP.sendMessage(new TextComponentTranslation("royalmod.breakblocks").appendText(" (").appendText(String.valueOf(oldStat + 1)).appendText("/100)").setStyle(new Style().setColor(TextFormatting.GREEN)));
                        }
                    }
                }
            } else {
                breaksBlock.put(playerMP, 1);
            }
        }
    }

    @SubscribeEvent
    public static void onDeathPlayerDropEXP(LivingExperienceDropEvent e) {
        if (e.getEntity() instanceof EntityPlayer) {
            if (e.getAttackingPlayer() != null) {
                CurrencyHelperServer.setCurrency(CommonReference.getPersistentUUID(e.getAttackingPlayer()), e.getAttackingPlayer().experienceLevel, 0);
            }
            e.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onRespPlayer(PlayerEvent.PlayerRespawnEvent e) {
        EntityPlayerMP playerMP = (EntityPlayerMP) e.player;
        playerMP.inventory.mainInventory.set(0, new ItemStack(pickage));
    }

    @SubscribeEvent
    public static void onDropsPlayer(PlayerDropsEvent e) {
        ListIterator<EntityItem> iter = e.getDrops().listIterator();
        while(iter.hasNext()) {
            EntityItem ei = iter.next();
            ItemStack stack = ei.getItem();
            if (stack.getItem().equals(ItemsRegistry.pickaxeDiamond)) {
               iter.remove();
               pickage = stack.getItem();
            }
            if (stack.getItem().equals(ItemsRegistry.pickaxeStone)) {
                iter.remove();
                pickage = stack.getItem();
            }
            if (stack.getItem().equals(ItemsRegistry.pickaxeIron)) {
                iter.remove();
                pickage = stack.getItem();
            }
            if (stack.getItem().equals(ItemsRegistry.pickaxeWood)) {
                iter.remove();
                pickage = stack.getItem();
            }
            if (stack.getItem().equals(Items.LEATHER_HELMET)) {
                iter.remove();
            }
        }
    }

    @SubscribeEvent
    public static void onBreak(PlayerInteractEvent.LeftClickBlock e) {
        if (!e.getEntityPlayer().isCreative()) {
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.COAL_ORE))  {
                e.setCanceled(!e.getItemStack().getItem().equals(ItemsRegistry.pickaxeWood) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeStone) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeIron) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeDiamond));
                return;
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.LAPIS_ORE)) {
                e.setCanceled(!e.getItemStack().getItem().equals(ItemsRegistry.pickaxeStone) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeIron) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeDiamond));
                return;
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.DIAMOND_ORE)) {
                e.setCanceled(!e.getItemStack().getItem().equals(ItemsRegistry.pickaxeDiamond));
                return;
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.EMERALD_ORE)) {
                e.setCanceled(!e.getItemStack().getItem().equals(ItemsRegistry.pickaxeDiamond));
                return;
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.GOLD_ORE)) {
                e.setCanceled(!e.getItemStack().getItem().equals(ItemsRegistry.pickaxeIron) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeDiamond));
                return;
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.IRON_ORE)) {
                e.setCanceled(!e.getItemStack().getItem().equals(ItemsRegistry.pickaxeStone) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeIron) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeDiamond));
                return;
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.REDSTONE_ORE)) {
                e.setCanceled(!e.getItemStack().getItem().equals(ItemsRegistry.pickaxeIron) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeDiamond));
                return;
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(Blocks.CHEST)) {
                e.setCanceled(false);
                return;
            }
            if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(BlocksRegister.BARRICADE)) {
                e.setCanceled(!e.getItemStack().getItem().equals(ItemsRegistry.pickaxeWood) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeStone) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeIron) &&
                        !e.getItemStack().getItem().equals(ItemsRegistry.pickaxeDiamond));
                return;
            }
            e.setCanceled(true);
        }
    }
}
