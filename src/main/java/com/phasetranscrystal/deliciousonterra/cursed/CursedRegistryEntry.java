package com.phasetranscrystal.deliciousonterra.cursed;

import com.mojang.datafixers.util.Either;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

public record CursedRegistryEntry<T>(T value, ResourceKey<? extends Registry<T>> key) implements Holder<T> {
    public CursedRegistryEntry(T value, ResourceKey<? extends Registry<T>> key) {
        this.value = value;
        this.key = key;
    }

    public boolean isBound() {
        return true;
    }

    public boolean is(ResourceLocation id) {
        return false;
    }

    public boolean is(ResourceKey<T> key) {
        return false;
    }

    public boolean is(TagKey<T> tag) {
        return false;
    }

    public boolean is(Holder<T> entry) {
        return false;
    }

    public boolean is(Predicate<ResourceKey<T>> predicate) {
        return false;
    }

    public Either<ResourceKey<T>, T> unwrap() {
        return Either.right(this.value);
    }

    public Optional<ResourceKey<T>> unwrapKey() {
        return Optional.of(ResourceKey.create(this.key, ResourceLocation.fromNamespaceAndPath("title_screen_mobs", "dummy")));
    }

    public Holder.Kind kind() {
        return Kind.DIRECT;
    }

    public String toString() {
        return "CursedRegistryEntry(This is from CICADA, please report there for any issues caused){" + String.valueOf(this.value) + "}";
    }

    public boolean canSerializeIn(HolderOwner<T> owner) {
        return true;
    }

    public Stream<TagKey<T>> tags() {
        return Stream.of();
    }

    public T value() {
        return this.value;
    }

    public ResourceKey<? extends Registry<T>> key() {
        return this.key;
    }
}
