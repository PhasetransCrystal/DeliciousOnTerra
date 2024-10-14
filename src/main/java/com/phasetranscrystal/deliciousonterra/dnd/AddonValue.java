package com.phasetranscrystal.deliciousonterra.dnd;


import net.minecraft.network.chat.Component;

import java.util.HashMap;
import java.util.Map;

public class AddonValue {
    private final Map<String,Integer> addonValue;
    private final Map<String,Component> tooltips = new HashMap<>();

    public AddonValue(){
        this.addonValue = new HashMap<>();
    }

    public AddonValue(Map<String,Integer> addonValue){
        this.addonValue = addonValue;
    }

    public AddonValue setAddonValue(String name, int value){
        this.addonValue.put(name, value);
        return this;
    }

    public void addTooltips(String name,Component tooltips){
        this.tooltips.put(name,tooltips);
    }

    public Component getTooltip(String name) {
        return tooltips.getOrDefault(name,Component.empty());
    }

    public Map<String,Integer> getAddonValue() {
        return addonValue;
    }
}
