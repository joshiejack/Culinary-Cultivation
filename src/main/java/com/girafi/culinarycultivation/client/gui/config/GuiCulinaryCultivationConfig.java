package com.girafi.culinarycultivation.client.gui.config;

import com.girafi.culinarycultivation.util.ConfigurationHandler;
import com.girafi.culinarycultivation.util.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class GuiCulinaryCultivationConfig extends GuiConfig {
    public GuiCulinaryCultivationConfig(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(), Reference.MOD_ID, true, true, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
    }

    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<>();

        List<IConfigElement> mobDrops = new ConfigElement(ConfigurationHandler.config.getCategory(ConfigurationHandler.CATEGORY_MOB_DROPS)).getChildElements();
        List<IConfigElement> modSupport = new ConfigElement(ConfigurationHandler.config.getCategory(ConfigurationHandler.CATEGORY_MOD_SUPPORT_ENABLING)).getChildElements();
        List<IConfigElement> rightClickHarvesting = new ConfigElement(ConfigurationHandler.config.getCategory(ConfigurationHandler.CATEGORY_RIGHT_CLICK_HARVESTING)).getChildElements();


        list.add(new DummyConfigElement.DummyCategoryElement("Mob Drops", Reference.MOD_ID + ".config.category.mobDrops", mobDrops));
        list.add(new DummyConfigElement.DummyCategoryElement("Mod Support", Reference.MOD_ID + ".config.category.modSupport", modSupport));
        list.add(new DummyConfigElement.DummyCategoryElement("Right Click Harvesting", Reference.MOD_ID + ".config.category.rightClickHarvesting", rightClickHarvesting));

        return list;
    }
}