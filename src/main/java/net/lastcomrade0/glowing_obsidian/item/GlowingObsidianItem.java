package net.lastcomrade0.glowing_obsidian.item;

import net.lastcomrade0.glowing_obsidian.GlowingObsidian;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GlowingObsidianItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GlowingObsidian.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
