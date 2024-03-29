package ua.andrey08xtomyoll.mineadditions.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ua.andrey08xtomyoll.mineadditions.blocks.*;
import ua.andrey08xtomyoll.mineadditions.tiles.TileThermalCrusher;
import ua.andrey08xtomyoll.mineadditions.tiles.TileAlchemyExtractor;

/**
 * Клас з блоками
 */
public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block LABATIUM_BLOCK 	= new ModOreBlock("labatium_block", Material.IRON);
    public static final Block TOMIUM_BLOCK = new ModOreBlock("tomium_block", Material.IRON);
    public static final Block LABATIUM_ORE 		= new LabatiumOre("labatium_ore", Material.ROCK);
    public static final Block TOMIUM_ORE = new TomiumOre("tomium_ore", Material.ROCK);
    public static final Block THERMALCRUSHER = new BlockThermalCrusher("thermalcrusher", Material.IRON, false);
    public static final Block THERMALCRUSHER_ON = new BlockThermalCrusher("thermalcrusher_on", Material.IRON, true);
    public static final Block LABATIUM_FRUIT_CROP = new LabatiumFruitCrop("labatium_fruit_crop");
    public static final Block TOMIUM_FRUIT_CROP = new TomiumFruitCrop("tomium_fruit_crop");
    public static final Block ALCHEMY_EXTRACTOR = new BlockAlchemyExtractor("alchemy_extractor", Material.IRON, false);
    public static final Block ALCHEMY_EXTRACTOR_ON = new BlockAlchemyExtractor("alchemy_extractor_on", Material.IRON, true);
    public static final Block STRANGE_DOOR = new StrangeDoor("strange_door", Material.WOOD);

    /**
     * Метод реєстрації механізмів
     */
    public static void register()
    {
    	GameRegistry.registerTileEntity(TileThermalCrusher.class, THERMALCRUSHER_ON.getRegistryName().toString());
        GameRegistry.registerTileEntity(TileAlchemyExtractor.class, ALCHEMY_EXTRACTOR_ON.getRegistryName().toString());
	}
}
