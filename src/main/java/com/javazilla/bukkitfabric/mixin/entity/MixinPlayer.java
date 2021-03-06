package com.javazilla.bukkitfabric.mixin.entity;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.javazilla.bukkitfabric.interfaces.IMixinCommandOutput;
import com.javazilla.bukkitfabric.interfaces.IMixinServerEntityPlayer;
import com.javazilla.bukkitfabric.interfaces.IMixinWorld;
import com.mojang.authlib.GameProfile;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(ServerPlayerEntity.class)
public class MixinPlayer extends MixinEntity implements IMixinCommandOutput, IMixinServerEntityPlayer  {

    private CraftPlayer bukkit;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(MinecraftServer server, ServerWorld world, GameProfile profile, ServerPlayerInteractionManager interactionManager, CallbackInfo ci) {
        this.bukkit = new CraftPlayer((ServerPlayerEntity) (Object) this);
        CraftServer.INSTANCE.playerView.add(this.bukkit);
    }

    @Override
    public CommandSender getBukkitSender(ServerCommandSource serverCommandSource) {
        return bukkit;
    }

    @Override
    public Entity getBukkitEntity() {
        return bukkit;
    }

    @Override
    public void reset() {
        // TODO Bukkit4Fabric: Auto-generated method stub
    }

    @Override
    public BlockPos getSpawnPoint(World world) {
        return ((ServerWorld)world).getSpawnPos();
    }

    @Inject(at = @At("TAIL"), method = "onDisconnect")
    public void onDisconnect(CallbackInfo ci) {
        CraftServer.INSTANCE.playerView.remove(this.bukkit);
    }

    @Overwrite
    public void teleport(ServerWorld worldserver, double d0, double d1, double d2, float f, float f1) {
        this.getBukkitEntity().teleport(new Location(((IMixinWorld)worldserver).getCraftWorld(), d0, d1, d2, f, f1), org.bukkit.event.player.PlayerTeleportEvent.TeleportCause.UNKNOWN);
    }

}