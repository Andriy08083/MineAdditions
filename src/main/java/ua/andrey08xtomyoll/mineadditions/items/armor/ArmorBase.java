package ua.andrey08xtomyoll.mineadditions.items.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import ua.andrey08xtomyoll.mineadditions.ModMain;
import ua.andrey08xtomyoll.mineadditions.init.ModItems;
import ua.andrey08xtomyoll.mineadditions.util.IHasEffect;
import ua.andrey08xtomyoll.mineadditions.util.IHasModel;

/**
 * Клас-конструктор універсальної броні
 */
public class ArmorBase extends ItemArmor implements IHasModel, IHasEffect {

    /**
     * Конструктор класу броні
     * @param name реєстраційне ім'я
     * @param materialIn матеріал, від якого наслідуються властивості
     * @param renderIndexIn індекс відмальовки
     * @param equipmentSlotIn слот, в який можна розмістити броню
     */
    public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setRegistryName(name);
        this.setTranslationKey(name);
        setCreativeTab(ModMain.creativeTab);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        ModMain.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
