package ovh.rootkovskiy.timadonatealert;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public class Main extends JavaPlugin {

    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("Plugin enabled");
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "TimaDonateAlert " + getDescription().getVersion() + " Loaded and Enabled!" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "MC Version: " + getServer().getBukkitVersion() + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "VK: @timurroot" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
    }

    public void onDisable() {
        getLogger().info("Plugin disabled");
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "TimaDonateAlert " + getDescription().getVersion() + " Disabled!" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "MC Version: " + getServer().getBukkitVersion() + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "VK: @timurroot" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Goodbye ;p" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("timadonatealert")) {

            if (!sender.hasPermission("timadonatealert.use")) {
                sender.sendMessage(getConfig().getString("messages.noperm").replace("&", "І"));
                return true;
            }

            if (args.length != 2) {
                sender.sendMessage(getConfig().getString("messages.usage").replace("&", "І"));
                return true;
            }

            sender.sendMessage(getConfig().getString("messages.complete").replace("&", "І"));
            getLogger().info(Console.ANSI_GREEN + getConfig().getString("messages.consolecomplete") + Console.ANSI_RESET);


            int r = new Random().nextInt(getConfig().getConfigurationSection("text").getKeys(false).size());
            List<String> selected = getConfig().getStringList("text." + r);

            selected.forEach(s -> Bukkit.broadcastMessage(s.replaceAll("%nick%", args[0]).replaceAll("%donate%", args[1]).replace("&", "І")));

            return true;
        }
        return true;
    }
}
