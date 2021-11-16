package ru.fotontv.royalmod.commands;

import com.google.common.collect.Lists;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.FMLServerHandler;
import ru.fotontv.royalmod.EventsHandler;

import java.util.List;

public class RegenBlock implements ICommand {

    @Override
    public int compareTo(ICommand arg0) {
        return 0;
    }

    @Override
    public String getName() {
        return "regenblock";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/regenblock";
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = Lists.newArrayList();
        aliases.add("/regenblock");
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EventsHandler.blocksSet.forEach((block, blockPos) -> {
            World world = FMLServerHandler.instance().getServer().getWorld(0);
            world.setBlockState(blockPos, block.getDefaultState());
        });
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
                                          BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }


}
