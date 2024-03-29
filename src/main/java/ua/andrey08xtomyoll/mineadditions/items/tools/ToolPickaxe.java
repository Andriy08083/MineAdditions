package ua.andrey08xtomyoll.mineadditions.items.tools;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ua.andrey08xtomyoll.mineadditions.ModMain;
import ua.andrey08xtomyoll.mineadditions.handlers.ConfigHandler;
import ua.andrey08xtomyoll.mineadditions.init.ModItems;
import ua.andrey08xtomyoll.mineadditions.util.IHasEffect;
import ua.andrey08xtomyoll.mineadditions.util.IHasModel;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Клас-конструктор кирки
 */
public class ToolPickaxe extends ItemPickaxe implements IHasModel, IHasEffect
{
    /**
     * Конструктор кирки
     * @param name реєстраційне ім'я інструменту
     * @param material матеріал, від якого успадковуються властивості інструменту
     */
    public ToolPickaxe(String name, ToolMaterial material)
    {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(ModMain.creativeTab);
        ModItems.ITEMS.add(this);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){return true;}

    /**
     * Подія, яка виконується при використанні предмету правою кнопкою миші
     * @return результат події
     */
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        NBTTagCompound nbt = new NBTTagCompound();
        if (handIn.equals(EnumHand.OFF_HAND)) {
            return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
        }
        if (playerIn.getHeldItem(handIn).hasTagCompound()) {
            nbt = playerIn.getHeldItem(handIn).getTagCompound();
        }
        if (!nbt.hasKey("zone")) {
            nbt.setInteger("zone", 1);
        }
        if (playerIn.isSneaking()) {
            if (ConfigHandler.GeneralSettings.depthModesArray.contains(nbt.getInteger("zone"))) {
                nbt.setInteger("zone", ConfigHandler.GeneralSettings.depthModesArray.get((ConfigHandler.GeneralSettings.depthModesArray.indexOf(nbt.getInteger("zone")) + 1) % ConfigHandler.GeneralSettings.depthModesArray.size()));
            }
            else {
                nbt.setInteger("zone", 1);
            }
            playerIn.getHeldItem(handIn).setTagCompound(nbt);
            if (worldIn.isRemote)
                playerIn.sendMessage(new TextComponentString("Depth - " + nbt.getInteger("zone")));
            return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
        }
        else
            return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));

    }

    /**
     * Подія, яка виконується при крафтингу предмета
     * @param stack предмет
     * @param worldIn світ
     * @param playerIn гравець, який скрафтив предмет
     */
    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("zone", 1);
        stack.setTagCompound(nbt);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("tools.depth.tooltip"));
    }

    @Override
    public void registerModels()
    {
        ModMain.proxy.registerItemRenderer(this,0,"inventory");
    }
}
