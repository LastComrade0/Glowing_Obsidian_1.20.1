package net.lastcomrade0.glowing_obsidian.block;

import net.lastcomrade0.glowing_obsidian.GlowingObsidian;
import net.lastcomrade0.glowing_obsidian.item.GlowingObsidianItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class GlowingObsidianBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GlowingObsidian.MODID);

    public static final RegistryObject<Block> GLOWING_OBSIDIAN_BLOCK = registerBlock("glowing_obsidian",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).lightLevel(state -> 14).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GLOWING_OBSIDIAN_LEGACY_BLOCK = registerBlock("glowing_obsidian_legacy",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).lightLevel(state -> 14).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        //Registers block
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        //Registers block item
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return GlowingObsidianItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

}
