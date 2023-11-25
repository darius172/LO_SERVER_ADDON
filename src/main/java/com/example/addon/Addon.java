package com.example.addon;

import com.example.addon.commands.ResetLastPos;
import com.example.addon.hud.HudExample;
import com.example.addon.modules.Bot_Mode_Module;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class Addon extends MeteorAddon {
    public static final String Mod_ID = "pixelutility";
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category Pixel_utility_Category = new Category("Pixel_utility");
    public static final HudGroup Pixel_utility_HUD = new HudGroup("Pixel_utility");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Mod with ModID: " + Mod_ID);

        // Modules
        Modules.get().add(new Bot_Mode_Module());

        // Commands
        Commands.add(new ResetLastPos());

        // HUD
        Hud.get().register(HudExample.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(Pixel_utility_Category);
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }
}
