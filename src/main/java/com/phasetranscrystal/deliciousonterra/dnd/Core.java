package com.phasetranscrystal.deliciousonterra.dnd;

import net.minecraft.world.entity.EntityType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Core {
    protected final Map<EntityType<?>,AddonValue> entityBaseAddon = new HashMap<>();
    protected final Map<UUID,AddonValue> dynamicAddon = new HashMap<>();
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        AddonValue addon = new AddonValue().setAddonValue("lucky",8).setAddonValue("weakness",-3);
        DNDConfig.debug = true;
        AddonDiceSystem sys = new AddonDiceSystem(20,addon,99);
        sys.addRollTime(99);
        sys.startRoll();
    }


}
