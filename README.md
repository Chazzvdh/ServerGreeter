**Description:**

The ServerGreeter plugin enhances the welcoming experience for players joining your Minecraft server. It allows server administrators to customize the welcome message displayed to players upon joining, making it more engaging and personalized. With support for placeholders and color codes, administrators can create dynamic and visually appealing welcome messages tailored to their server's style.

**Key Features:**
- **Customizable Welcome Message:** Administrators can configure a personalized welcome message using placeholders to greet players as they join the server.
- **Color Support:** The plugin supports color codes in the welcome message, enabling administrators to add visual flair and emphasis.
- **Configuration Reload Command:** The `/sg reload` command allows administrators to reload the plugin configuration in-game, facilitating easy customization without server restarts.
- **Test Title Command:** Administrators can manually trigger the welcome title message using the `/sg test` command, providing a convenient way to preview the welcome message without waiting for a player to join.

![image](https://github.com/Chazzvdh/ServerGreeter/assets/114153884/84d31e8a-62f3-458e-859e-693645a62f3c)

**Usage:**

- **/sg reload:** Reloads the plugin configuration, applying any changes made to the welcome message or other settings without restarting the server. This command is essential for administrators to customize the welcome message on the fly.
  - Permission: servergreeter.reload

- **/sg test:** Manually triggers a test title message for the executing player, allowing administrators to preview the welcome message without waiting for a player to join the server. This command is useful for ensuring the welcome message looks as intended before players join.
  - Permission: servergreeter.test

Upon joining the server, players will be greeted with the customized welcome message specified in the plugin configuration. The welcome message can include placeholders such as `%player%` to dynamically insert the player's name, providing a personalized experience for each player.
