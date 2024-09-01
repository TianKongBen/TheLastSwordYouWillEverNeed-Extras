package net.tianben.tlsywenextras.item.group;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tianben.tlsywen.TheLastSwordYouWillEverNeed;
import net.tianben.tlsywen.item.ModItems;

public class ModItemGroups {
    public static final ItemGroup the_last_sword_you_will_ever_need = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheLastSwordYouWillEverNeed.MOD_ID, "the_last_sword_you_will_ever_need"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.the_last_sword_you_will_ever_need"))
                    .icon(() -> new ItemStack(ModItems.REALLYTHELASTSWORDYOUWILLEVERNEED)).entries((displayContext, entries) -> {
                    }).build());


    public static void registerItemGroups() {
        TheLastSwordYouWillEverNeed.LOGGER .info("Registering Item Groups for " +TheLastSwordYouWillEverNeed.MOD_ID);
    }
}
