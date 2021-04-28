package ua.andrey08xtomyoll.mineadditions.handlers;


import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ua.andrey08xtomyoll.mineadditions.util.Reference;

@Config(modid = Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ConfigHandler {

    @Config.LangKey(Reference.MOD_ID + ".cfg.labatium_category")
    public static LabatiumSettings labatiumSettings = new LabatiumSettings();
    @Config.LangKey(Reference.MOD_ID + ".cfg.mazurium_category")
    public static MazuriumSettings mazuriumSettings = new MazuriumSettings();
    @Config.LangKey(Reference.MOD_ID + ".cfg.ore_gen_category")
    public static OreGenSettings oreGenSettings = new OreGenSettings();


    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MOD_ID)) {
            ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
        }
    }

    public static class LabatiumSettings {

        @Config.LangKey(Reference.MOD_ID + ".cfg.depth_modes")
        @Config.Comment("Split values by | symbol")
        public String depthModes = "1|3|5";

        @Config.LangKey(Reference.MOD_ID + ".cfg.can_fly")
        @Config.Comment("Split values by | symbol")
        public boolean canFly = true;

        @Config.LangKey(Reference.MOD_ID + ".cfg.overall_resistance")
        public int overallResistance = 33;
        @Config.LangKey(Reference.MOD_ID + ".cfg.helmet_resistance")
        public int helmetResistance = 4;
        @Config.LangKey(Reference.MOD_ID + ".cfg.chestplate_resistance")
        public int chestplateResistance = 6;
        @Config.LangKey(Reference.MOD_ID + ".cfg.leggings_resistance")
        public int leggingsResistance = 5;
        @Config.LangKey(Reference.MOD_ID + ".cfg.boots_resistance")
        public int bootsResistance = 4;
        @Config.LangKey(Reference.MOD_ID + ".cfg.overall_toughness")
        public float overallToughness = 10;
    }

    public static class MazuriumSettings {

        @Config.LangKey(Reference.MOD_ID + ".cfg.depth_modes")
        @Config.Comment("Split values by | symbol")
        public String depthModes = "1|3|5";

        @Config.LangKey(Reference.MOD_ID + ".cfg.can_fly")
        @Config.Comment("Split values by | symbol")
        public boolean canFly = true;

        @Config.LangKey(Reference.MOD_ID + ".cfg.overall_resistance")
        public int overallResistance = 33;
        @Config.LangKey(Reference.MOD_ID + ".cfg.helmet_resistance")
        public int helmetResistance = 4;
        @Config.LangKey(Reference.MOD_ID + ".cfg.chestplate_resistance")
        public int chestplateResistance = 6;
        @Config.LangKey(Reference.MOD_ID + ".cfg.leggings_resistance")
        public int leggingsResistance = 5;
        @Config.LangKey(Reference.MOD_ID + ".cfg.boots_resistance")
        public int bootsResistance = 4;
        @Config.LangKey(Reference.MOD_ID + ".cfg.overall_toughness")
        public float overallToughness = 10;
    }

    public static class OreGenSettings {
        @Config.LangKey(Reference.MOD_ID + ".cfg.labatium_min_height")
        @Config.RangeInt(min = 1, max = 255)
        public int labatiumMinHeight = 8;
        @Config.LangKey(Reference.MOD_ID + ".cfg.labatium_max_height")
        @Config.RangeInt(min = 20, max = 255)
        public int labatiumMaxHeight = 20;
        @Config.LangKey(Reference.MOD_ID + ".cfg.labatium_per_chunk_spawn")
        public int labatiumPerChunkSpawn = 4;

        @Config.LangKey(Reference.MOD_ID + ".cfg.mazurium_min_height")
        @Config.RangeInt(min = 1, max = 255)
        public int mazuriumMinHeight = 8;
        @Config.LangKey(Reference.MOD_ID + ".cfg.mazurium_max_height")
        @Config.RangeInt(min = 20, max = 255)
        public int mazuriumMaxHeight = 20;
        @Config.LangKey(Reference.MOD_ID + ".cfg.mazurium_per_chunk_spawn")
        public int mazuriumPerChunkSpawn = 4;

    }

}