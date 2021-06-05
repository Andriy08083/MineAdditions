package ua.andrey08xtomyoll.mineadditions.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ua.andrey08xtomyoll.mineadditions.ModMain;
import ua.andrey08xtomyoll.mineadditions.init.ModBlocks;
import ua.andrey08xtomyoll.mineadditions.init.ModItems;

/**
 * Клас рецептів термічного подрібнювачу
 */
public class TCrusherRecipies
{

    private static final ArrayList<List<Item>> inputList 			= new ArrayList<List<Item>>();
    // Основной результат
    private static final ArrayList<Item> resultList 				= new ArrayList<Item>();
    // Суб-продукты
    private static final ArrayList<List<Item>> subOutputList 		= new ArrayList<List<Item>>();
    // Время плавки
    private static final ArrayList<Integer> timeList 				= new ArrayList<Integer>();


    /**
     * Метод ініціалізації рецептів
     */
    public static void init()
    {
		/* Рецепты состоят из:
		- int время плавления
		- Item[]{} список  исходных (до 5 соответсвенно)
		- Item основной результат
		- Item[]{} список  суб-результатов (до 4х соответсвенно)
		*/
        TCrusherRecipies.addFurnaceRecipeWithCookTime(2000, new Item[]{Item.getItemFromBlock(ModBlocks.LABATIUM_ORE)}, ModItems.LITTLE_LABATIUM_DUST, new Item[]{});
        TCrusherRecipies.addFurnaceRecipeWithCookTime(2000, new Item[]{Item.getItemFromBlock(ModBlocks.TOMIUM_ORE)}, ModItems.LITTLE_TOMIUM_DUST, new Item[]{});
    }

    /**
     * Метод додавання рецептів
     * @param cookTime час готування
     * @param inputRaw масив вхідних предметів
     * @param result результат
     * @param outputRaw масив побічних результатів
     */
    public static void addFurnaceRecipeWithCookTime(int cookTime, Item[] inputRaw, Item result, Item[] outputRaw)
    {
        List<Item> input = new ArrayList<Item>();
        for(int i = 0; i < inputRaw.length; i++)
            input.add(inputRaw[i]);

        List<Item> output = new ArrayList<Item>();
        for(int i = 0; i < outputRaw.length; i++)
            output.add(outputRaw[i]);

        // Проверяем, что входящие и результат существуют
        if (result == null)
            return;
        for(int i = 0; i < input.size(); i++){
            if (input.get(i) == null)
                return;
        }
        ModMain.log("Рецепт на " + new ItemStack(result).getDisplayName() + " зарегестрирован.");
        timeList.add(cookTime);
        inputList.add(input);
        resultList.add(result);
        subOutputList.add(output);
    }

    /**
     * Геттер часу приготування з рецепту
     * @param input масив вхідних предметів рецепту
     * @return результат
     */
    public static int getCookTimeForItems(List<Item> input)
    {
        boolean isEmpty = true;
        for(int i = 0; i < input.size(); i++){
            if (input.get(i) != null){
                isEmpty =  false;
                break;
            }
        }
        if(isEmpty){
            return 200;
        }

        int matches = 0;

        for (int i = 0; i < inputList.size(); i++){
            if(input.size() != inputList.get(i).size()){
                continue;
            }
            for(int n = 0; n < input.size(); n++){
                for(int m = 0; m < inputList.get(i).size(); m++){
                    if(inputList.get(i).get(m) == input.get(n)){
                        matches++;
                        continue;
                    }
                }
            }

            if(matches == input.size()){
                return timeList.get(i);
            }
            else{
                matches = 0;
            }
        }
        return 200;
    }

    /**
     * Геттер результатів з рецепту
     * @param input масив вхідних предметів рецепту
     * @return результат
     */
    public static Item getResultForItems(List<Item> input)
    {
        boolean isEmpty = true;
        for(int i = 0; i < input.size(); i++){
            if (input.get(i) != null){
                isEmpty =  false;
                break;
            }
        }
        if(isEmpty){
            return null;
        }

        int matches = 0;

        for (int i = 0; i < inputList.size(); i++){
            if(input.size() != inputList.get(i).size()){
                continue;
            }
            for(int n = 0; n < input.size(); n++){
                for(int m = 0; m < inputList.get(i).size(); m++){
                    if(inputList.get(i).get(m) == input.get(n)){
                        matches++;
                    }
                }
            }

            if(matches == input.size()){
                return resultList.get(i);
            }
            else{
                matches = 0;
            }
        }

        ModMain.log("После проверки всех рецептов совпадения не найдено.");
        return null;
    }

    /**
     * Геттер побічних результатів з рецепту
     * @param input масив вхідних предметів рецепту
     * @return масив побічних предметів
     */
    public static List<Item> getSubsForItems(List<Item> input)
    {
        boolean isEmpty = true;
        for(int i = 0; i < input.size(); i++)
        {
            if (input.get(i) != null)
            {
                isEmpty =  false;
                break;
            }
        }
        if(isEmpty){
            return null;
        }

        int matches = 0;

        for (int i = 0; i < inputList.size(); i++)
        {
            if(input.size() != inputList.get(i).size())
            {
                continue;
            }
            for(int n = 0; n < input.size(); n++)
            {
                for(int m = 0; m < inputList.get(i).size(); m++)
                {
                    if(inputList.get(i).get(m) == input.get(n))
                    {
                        matches++;
                    }
                }
            }

            if(matches == input.size())
            {
                return subOutputList.get(i);
            }
            else{
                matches = 0;
            }
        }
        return null;
    }

}