package org.bukkit.craftbukkit.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.Hand;

public class CraftLivingEntity extends CraftEntity implements LivingEntity {

    public net.minecraft.entity.LivingEntity nms;

    public CraftLivingEntity(net.minecraft.entity.Entity entity) {
        super(entity);
        this.nms = (net.minecraft.entity.LivingEntity) entity;
        // TODO Auto-generated constructor stub
    }

    @Override
    public AttributeInstance getAttribute(Attribute arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void damage(double arg0) {
        nms.damage(DamageSource.MAGIC, (float)arg0);
    }

    @Override
    public void damage(double arg0, Entity arg1) {
        nms.damage(DamageSource.mob((net.minecraft.entity.LivingEntity) arg1), (float) arg0);
    }

    @Override
    public double getAbsorptionAmount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getHealth() {
        return nms.getHealth();
    }

    @Override
    public double getMaxHealth() {
        // TODO Auto-generated method stub
        return nms.getMaxHealth();
    }

    @Override
    public void resetMaxHealth() {
        // TODO Auto-generated method stub
    }

    @Override
    public void setAbsorptionAmount(double arg0) {
        nms.setAbsorptionAmount((float)arg0);
    }

    @Override
    public void setHealth(double arg0) {
        nms.setHealth((float) arg0);
    }

    @Override
    public void setMaxHealth(double arg0) {
        // TODO Max health
        nms.setHealth((float) arg0);
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> arg0, Vector arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addPotionEffect(PotionEffect arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addPotionEffect(PotionEffect arg0, boolean arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addPotionEffects(Collection<PotionEffect> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void attack(Entity arg0) {
        nms.attackLivingEntity(((CraftLivingEntity)arg0).nms);
    }

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getCanPickupItems() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public EntityEquipment getEquipment() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getEyeHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getEyeHeight(boolean arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Location getEyeLocation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Player getKiller() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getLastDamage() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(Set<Material> arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entity getLeashHolder() throws IllegalStateException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Block> getLineOfSight(Set<Material> arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getMaximumAir() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMaximumNoDamageTicks() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <T> T getMemory(MemoryKey<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getNoDamageTicks() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public PotionEffect getPotionEffect(PotionEffectType arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getRemainingAir() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Block getTargetBlock(Set<Material> arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Block getTargetBlockExact(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Block getTargetBlockExact(int arg0, FluidCollisionMode arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasAI() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean hasLineOfSight(Entity arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasPotionEffect(PotionEffectType arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCollidable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isGliding() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLeashed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isRiptiding() {
        return nms.isUsingRiptide();
    }

    @Override
    public boolean isSleeping() {
        return nms.isSleeping();
    }

    @Override
    public boolean isSwimming() {
        return nms.isSwimming();
    }

    @Override
    public RayTraceResult rayTraceBlocks(double arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RayTraceResult rayTraceBlocks(double arg0, FluidCollisionMode arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removePotionEffect(PotionEffectType arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setAI(boolean arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setCanPickupItems(boolean arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setCollidable(boolean arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setGliding(boolean arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setLastDamage(double arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean setLeashHolder(Entity arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setMaximumAir(int arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setMaximumNoDamageTicks(int arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public <T> void setMemory(MemoryKey<T> arg0, T arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setNoDamageTicks(int arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setRemainingAir(int arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setRemoveWhenFarAway(boolean arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setSwimming(boolean arg0) {
        nms.setSwimming(arg0);
    }

    @Override
    public void swingMainHand() {
        nms.swingHand(Hand.MAIN_HAND);
    }

    @Override
    public void swingOffHand() {
        nms.swingHand(Hand.OFF_HAND);
    }

    @Override
    public Set<UUID> getCollidableExemptions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EntityCategory getCategory() {
        // TODO Auto-generated method stub
        return EntityCategory.NONE;
    }

}
