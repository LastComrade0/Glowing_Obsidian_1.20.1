package net.lastcomrade0.datagen;

import net.lastcomrade0.glowing_obsidian.GlowingObsidian;
import net.lastcomrade0.glowing_obsidian.block.GlowingObsidianBlock;
import net.lastcomrade0.glowing_obsidian.item.GlowingObsidianItem;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // Example: simple shaped recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GlowingObsidianBlock.GLOWING_OBSIDIAN_BLOCK.get())
                .pattern("G G")
                .pattern(" O ")
                .pattern("G G")
                .define('G', Items.GLOWSTONE_DUST)
                .define('O', Items.OBSIDIAN)
                .unlockedBy("has_glowing_obsidian", has(Items.OBSIDIAN))
                .save(pWriter);
    }
}
