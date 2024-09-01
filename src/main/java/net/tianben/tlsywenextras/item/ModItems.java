package net.tianben.tlsywenextras.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tianben.tlsywen.TheLastSwordYouWillEverNeed;

public class ModItems{

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TheLastSwordYouWillEverNeed.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TheLastSwordYouWillEverNeed.LOGGER.info("Registering Mod Items for " + TheLastSwordYouWillEverNeed.MOD_ID);
    }
}
