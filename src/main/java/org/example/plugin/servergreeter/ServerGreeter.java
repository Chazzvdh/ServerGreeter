package org.example.plugin.servergreeter;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerGreeter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Register the event listener
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();

        // Print a message to the console when the plugin starts
        getLogger().info("ServerGreeter plugin has been enabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("sg")) {
            // Check if the command is /sg reload
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                // Reload the configuration
                reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "ServerGreeter configuration reloaded!");
                return true;
            }
            // Check if the command is /sg test
            else if (args.length == 1 && args[0].equalsIgnoreCase("test")) {
                // Check if the sender is a player
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    // Trigger the title message for the player
                    triggerTitle(player);
                    return true;
                } else {
                    // Command can only be executed by players
                    sender.sendMessage(ChatColor.RED + "This command can only be executed by players!");
                    return false;
                }
            }
        }
        return false;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Trigger the title message for the player who joined
        triggerTitle(event.getPlayer());
    }

    private void triggerTitle(Player player) {
        // Get placeholders from configuration
        String serverNamePlaceholder = getConfig().getString("placeholders.server_name");
        String welcomeMessagePlaceholder = getConfig().getString("placeholders.welcome_message");

        // Replace placeholders with actual values
        String serverName = ChatColor.translateAlternateColorCodes('&', serverNamePlaceholder);
        String welcomeMessage = ChatColor.translateAlternateColorCodes('&', welcomeMessagePlaceholder.replace("%player%", player.getName()));

        // Send the welcome message as a title to the player
        player.sendTitle(
                serverName, // Title
                welcomeMessage, // Subtitle
                10, // Fade in ticks
                70, // Stay ticks
                20 // Fade out ticks
        );
    }
}
