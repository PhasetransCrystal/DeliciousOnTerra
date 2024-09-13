//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.phasetranscrystal.deliciousonterra.cursed;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Lifecycle;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder.Reference;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.neoforged.neoforge.registries.callback.RegistryCallback;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record CursedRegistry<T>(ResourceKey<? extends Registry<T>> registryKey, ResourceLocation defaultId, T defaultValue) implements Registry<T>, HolderOwner<T> {
    public CursedRegistry(ResourceKey<? extends Registry<T>> registryKey, ResourceLocation defaultId, T defaultValue) {
        this.registryKey = registryKey;
        this.defaultId = defaultId;
        this.defaultValue = defaultValue;
    }

    public ResourceKey<? extends Registry<T>> key() {
        return this.registryKey;
    }

    public @Nullable ResourceLocation getKey(T value) {
        return this.defaultId;
    }

    public Optional<ResourceKey<T>> getResourceKey(T entry) {
        return Optional.empty();
    }

    public int getId(@Nullable T value) {
        return 0;
    }

    public @Nullable T byId(int index) {
        return this.defaultValue;
    }

    public int size() {
        return 1;
    }

    public @Nullable T get(@Nullable ResourceKey<T> key) {
        return this.defaultValue;
    }

    public @Nullable T get(@Nullable ResourceLocation id) {
        return this.defaultValue;
    }

    public Optional<RegistrationInfo> registrationInfo(ResourceKey<T> key) {
        return Optional.empty();
    }

    public Optional<Holder.Reference<T>> getHolder(ResourceLocation id) {
        return Optional.empty();
    }

    public Lifecycle registryLifecycle() {
        return Lifecycle.experimental();
    }

    public Optional<Holder.Reference<T>> getAny() {
        return Optional.empty();
    }

    public Set<ResourceLocation> keySet() {
        return Set.of(this.defaultId);
    }

    public Set<Map.Entry<ResourceKey<T>, T>> entrySet() {
        return Set.of();
    }

    public Set<ResourceKey<T>> registryKeySet() {
        return Set.of();
    }

    public Optional<Holder.Reference<T>> getRandom(RandomSource random) {
        return Optional.empty();
    }

    public boolean containsKey(ResourceLocation id) {
        return true;
    }

    public boolean containsKey(ResourceKey<T> key) {
        return true;
    }

    public Registry<T> freeze() {
        return this;
    }

    public Holder.Reference<T> createIntrusiveHolder(T value) {
        return Reference.createIntrusive(this, value);
    }

    public Optional<Holder.Reference<T>> getHolder(int rawId) {
        return Optional.empty();
    }

    public Optional<Holder.Reference<T>> getHolder(ResourceKey<T> key) {
        return Optional.of(Reference.createStandAlone(this, key));
    }

    public Holder<T> wrapAsHolder(T value) {
        return Holder.direct(value);
    }

    public Stream<Holder.Reference<T>> holders() {
        return null;
    }

    public Optional<HolderSet.Named<T>> getTag(TagKey<T> tag) {
        return Optional.empty();
    }

    public HolderSet.Named<T> getOrCreateTag(TagKey<T> tag) {
        return HolderSet.emptyNamed(this, tag);
    }

    public Stream<Pair<TagKey<T>, HolderSet.Named<T>>> getTags() {
        return Stream.empty();
    }

    public Stream<TagKey<T>> getTagNames() {
        return Stream.empty();
    }

    public void resetTags() {
    }

    public void bindTags(Map<TagKey<T>, List<Holder<T>>> tagEntries) {
    }

    public HolderOwner<T> holderOwner() {
        return this;
    }

    public HolderLookup.RegistryLookup<T> asLookup() {
        return new HolderLookup.RegistryLookup<T>() {
            public ResourceKey<? extends Registry<? extends T>> key() {
                return CursedRegistry.this.registryKey;
            }

            public Lifecycle registryLifecycle() {
                return Lifecycle.experimental();
            }

            public Stream<Holder.Reference<T>> listElements() {
                return Stream.empty();
            }

            public Stream<HolderSet.Named<T>> listTags() {
                return Stream.empty();
            }

            public Optional<Holder.Reference<T>> get(ResourceKey<T> key) {
                return Optional.empty();
            }

            public Optional<HolderSet.Named<T>> get(TagKey<T> tag) {
                return Optional.empty();
            }
        };
    }

    public @NotNull Iterator<T> iterator() {
        return new Iterator<T>() {
            public boolean hasNext() {
                return false;
            }

            public T next() {
                return null;
            }
        };
    }

    public ResourceKey<? extends Registry<T>> registryKey() {
        return this.registryKey;
    }

    public ResourceLocation defaultId() {
        return this.defaultId;
    }

    public T defaultValue() {
        return this.defaultValue;
    }

    @Override
    public boolean doesSync() {
        return false;
    }

    @Override
    public int getMaxId() {
        return 0;
    }

    @Override
    public void addCallback(RegistryCallback<T> callback) {

    }

    @Override
    public void addAlias(ResourceLocation from, ResourceLocation to) {

    }

    @Override
    public ResourceLocation resolve(ResourceLocation name) {
        return null;
    }

    @Override
    public ResourceKey<T> resolve(ResourceKey<T> key) {
        return null;
    }

    @Override
    public int getId(ResourceKey<T> key) {
        return 0;
    }

    @Override
    public int getId(ResourceLocation name) {
        return 0;
    }

    @Override
    public boolean containsValue(T value) {
        return false;
    }

    @Override
    public <A> @Nullable A getData(DataMapType<T, A> type, ResourceKey<T> key) {
        return null;
    }

    @Override
    public <A> Map<ResourceKey<T>, A> getDataMap(DataMapType<T, A> type) {
        return null;
    }
}