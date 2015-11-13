package com.Girafi.culinarycultivation.init;

import com.Girafi.culinarycultivation.creativetab.CreativeTab;
import com.Girafi.culinarycultivation.item.*;
import com.Girafi.culinarycultivation.item.equipment.armor.farmer.ItemFarmerBoots;
import com.Girafi.culinarycultivation.item.equipment.armor.farmer.ItemFarmerOveralls;
import com.Girafi.culinarycultivation.item.equipment.armor.farmer.ItemFarmerShirt;
import com.Girafi.culinarycultivation.item.equipment.armor.farmer.ItemFarmerStrawhat;
import com.Girafi.culinarycultivation.item.equipment.tool.*;
import com.Girafi.culinarycultivation.reference.Paths;
import com.Girafi.culinarycultivation.reference.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraftforge.common.FishingHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static final Item cakeKnife = new ItemCakeKnife(Item.ToolMaterial.IRON);
    public static final Item caneKnife = new ItemCaneKnife(Item.ToolMaterial.STONE);
    public static final Item debugItem = new ItemDebugItem();
    public static final Item farmerBoots = new ItemFarmerBoots();
    public static final Item farmerOveralls = new ItemFarmerOveralls();
    public static final Item farmerShirt = new ItemFarmerShirt();
    public static final Item farmerStrawhat = new ItemFarmerStrawhat();
    public static final Item kitchenKnife = new ItemKnife(Item.ToolMaterial.IRON);
    public static final Item meatCleaver = new ItemMeatCleaver(Item.ToolMaterial.IRON);
    public static final Item storageJar = new ItemStorageJar();
    public static final Item toolHandle = new Item().setUnlocalizedName(Paths.ModAssets + "toolHandle").setCreativeTab(CreativeTab.CulinaryCultivation_Tab);
    public static final Item wooden_hoeLarge = new ItemLargeHoe(Item.ToolMaterial.WOOD).setUnlocalizedName(Paths.ModAssets + "hoeLargeWood");
    public static final Item stone_hoeLarge = new ItemLargeHoe(Item.ToolMaterial.STONE).setUnlocalizedName(Paths.ModAssets + "hoeLargeStone");
    public static final Item iron_hoeLarge = new ItemLargeHoe(Item.ToolMaterial.IRON).setUnlocalizedName(Paths.ModAssets + "hoeLargeIron");
    public static final Item golden_hoeLarge = new ItemLargeHoe(Item.ToolMaterial.GOLD).setUnlocalizedName(Paths.ModAssets + "hoeLargeGolden");
    public static final Item diamond_hoeLarge = new ItemLargeHoe(Item.ToolMaterial.EMERALD).setUnlocalizedName(Paths.ModAssets + "hoeLargeDiamond");

    ////Food
    public static final Item beetroot = new SourceFood(1, 0.1F, false).setUnlocalizedName("beetroot");
    public static final Item beetrootSoup = new ItemSoup(8).setUnlocalizedName(Paths.ModAssets + "beetrootSoup").setCreativeTab(CreativeTab.CulinaryCultivation_Tab);
    public static final Item cheeseSlice = new SourceFood(2, 0.4F, false).setUnlocalizedName("cheeseSlice");
    public static final Item cooked_fish = new ItemModFishFood(true).setHasSubtypes(true);
    public static final Item cooked_meat = new ItemModMeatFood(true).setHasSubtypes(true);
    public static final Item fish = new ItemModFishFood(false).setHasSubtypes(true);
    public static final Item cropFood = new ItemCropFood().setHasSubtypes(true);
    public static final Item beetrootSeeds = new ItemSeeds(ModBlocks.beetroots, Blocks.farmland).setUnlocalizedName(Paths.ModAssets + "beetrootSeeds").setCreativeTab(CreativeTab.CulinaryCultivation_Tab);
    public static final Item cropSeeds = new ItemCropSeeds().setHasSubtypes(true);
    public static final Item meat = new ItemModMeatFood(false).setHasSubtypes(true);
    public static final Item pieceOfCake = new SourceFood(2, 0.1F, false).setUnlocalizedName("pieceOfCake");
    public static final Item calfBelly = new Item().setUnlocalizedName(Paths.ModAssets + "calfBelly").setMaxStackSize(1).setCreativeTab(CreativeTab.CulinaryCultivation_Tab);

    //public static final Item chickenWingHot = new SourceFood(5, 0.8F, true).setPotionEffect(Potion.fireResistance.id, 15, 0, 0.25F).setUnlocalizedName("chickenWingHot");
    //public static final Item sausage = new SourceFood(0, 0.0F, true).setUnlocalizedName("sausage"));

    public static void init() { //Will show up in this order in NEI and Creative Tab
        GameRegistry.registerItem(cheeseSlice, "cheeseSlice");
        GameRegistry.registerItem(pieceOfCake, "pieceOfCake");
        GameRegistry.registerItem(calfBelly, "calfBelly");
        GameRegistry.registerItem(meat, "meat");
        GameRegistry.registerItem(cooked_meat, "cooked_meat");
        GameRegistry.registerItem(fish, "fish");
        GameRegistry.registerItem(cooked_fish, "cooked_fish");
        GameRegistry.registerItem(beetrootSeeds, "beetRootSeeds");
        GameRegistry.registerItem(beetroot, "beetroot");
        GameRegistry.registerItem(beetrootSoup, "beetRootSoup");
        GameRegistry.registerItem(cropFood, "cropFood");
        GameRegistry.registerItem(cropSeeds, "cropSeeds");
        GameRegistry.registerItem(storageJar, "storageJar");
        GameRegistry.registerItem(toolHandle, "toolHandle");
        GameRegistry.registerItem(kitchenKnife, "kitchenKnife");
        GameRegistry.registerItem(cakeKnife, "cakeKnife");
        GameRegistry.registerItem(meatCleaver, "meatCleaver");
        GameRegistry.registerItem(caneKnife, "caneKnife");
        GameRegistry.registerItem(wooden_hoeLarge, "wooden_hoeLarge");
        GameRegistry.registerItem(stone_hoeLarge, "stone_hoeLarge");
        GameRegistry.registerItem(iron_hoeLarge, "iron_hoeLarge");
        GameRegistry.registerItem(golden_hoeLarge, "golden_hoeLarge");
        GameRegistry.registerItem(diamond_hoeLarge, "diamond_hoeLarge");
        GameRegistry.registerItem(debugItem, "debugItem");
        GameRegistry.registerItem(farmerStrawhat, "farmerStrawhat");
        GameRegistry.registerItem(farmerShirt, "farmerShirt");
        GameRegistry.registerItem(farmerOveralls, "farmerOveralls");
        GameRegistry.registerItem(farmerBoots, "farmerBoots");
        MinecraftForge.EVENT_BUS.register(new ItemDebugItem());
    }

    public static void setup() {
        FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(ModItems.fish, 1, ItemModFishFood.FishType.MACKEREL.getMetaData()), 48));
        FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(ModItems.fish, 1, ItemModFishFood.FishType.TUNA.getMetaData()), 40));
        FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(ModItems.fish, 1, ItemModFishFood.FishType.TROUT.getMetaData()), 25));
        FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(ModItems.fish, 1, ItemModFishFood.FishType.HERRING.getMetaData()), 30));
        FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(ModItems.fish, 1, ItemModFishFood.FishType.PLAICE.getMetaData()), 18));
        FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(ModItems.fish, 1, ItemModFishFood.FishType.SMALLSQUID.getMetaData()), 11));
        FishingHooks.addJunk(new WeightedRandomFishable(new ItemStack(ModItems.meatCleaver, 1), 3).setMaxDamagePercent(0.25F));
    }
}