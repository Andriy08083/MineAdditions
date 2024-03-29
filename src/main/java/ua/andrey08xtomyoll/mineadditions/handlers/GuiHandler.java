package ua.andrey08xtomyoll.mineadditions.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import ua.andrey08xtomyoll.mineadditions.tiles.TileThermalCrusher;
import ua.andrey08xtomyoll.mineadditions.tiles.TileAlchemyExtractor;
import ua.andrey08xtomyoll.mineadditions.gui.GuiElchemyExtractor;
import ua.andrey08xtomyoll.mineadditions.gui.GuiThermalCrusher;
import ua.andrey08xtomyoll.mineadditions.gui.containers.ContainerAlchemyExtractor;
import ua.andrey08xtomyoll.mineadditions.gui.containers.ContainerThermalCrusher;

public class GuiHandler implements IGuiHandler {

	public static int id = 0;
	public static final int GUI_THERMAL_CRUSHER = id++;
	public static final int GUI_ALCHEMY_EXTRACTOR = id++;

	/**
	 * Повертає контейнер на стороні сервера (не GUI)
	 * @param ID ідентифікатор GUI тайла
	 * @param player гравець
	 * @param world світ
	 * @param x
	 * @param y
	 * @param z
	 * @return контейнер
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GUI_THERMAL_CRUSHER) {
				System.out.println("[S] crusher != null");
				return new ContainerThermalCrusher(player.inventory, (TileThermalCrusher)world.getTileEntity(new BlockPos(x, y, z)));
        }
		else if(ID == GUI_ALCHEMY_EXTRACTOR)
		{
			System.out.println("[S] crusher != null");
			return new ContainerAlchemyExtractor(player.inventory, (TileAlchemyExtractor)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	/**
	 * Повертає GUI на стороні клієнта (не контейнер)
	 * @param ID ідентифікатор GUI тайла
	 * @param player гравець
	 * @param world світ
	 * @param x
	 * @param y
	 * @param z
	 * @return GUI
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GUI_THERMAL_CRUSHER) {
			System.out.println("[C] GUI = ThermalCrusher");
			return new GuiThermalCrusher(player.inventory, (TileThermalCrusher)world.getTileEntity(new BlockPos(x, y, z)));
        }
		else if(ID == GUI_ALCHEMY_EXTRACTOR)
		{
			System.out.println("[S] crusher != null");
			return new GuiElchemyExtractor(player.inventory, (TileAlchemyExtractor)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

}
