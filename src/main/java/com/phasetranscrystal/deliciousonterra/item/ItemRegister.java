package com.phasetranscrystal.deliciousonterra.item;

import com.phasetranscrystal.deliciousonterra.DeliciousOnTerra;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemRegister {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DeliciousOnTerra.MODID);
    public static final DeferredItem<Item> TEST_ITEM = register("test_item", () -> new TestItem(new Item.Properties()));

    public static <T extends Item> DeferredItem<T> register(String name, Supplier<T> item) {
        DeferredItem<T> i = ITEMS.register(name, item);
        DOTItemTabs.ITEMS.add(i);
        return i;
    }
}
