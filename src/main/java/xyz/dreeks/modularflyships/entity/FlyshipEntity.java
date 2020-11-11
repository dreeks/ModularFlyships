package xyz.dreeks.modularflyships.entity;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.class_5459;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import xyz.dreeks.modularflyships.ModularFlyships;
import xyz.dreeks.modularflyships.client.gui.GuiFlyship;
import xyz.dreeks.modularflyships.model.EnumMovementMode;
import xyz.dreeks.modularflyships.model.PressedKey;
import xyz.dreeks.modularflyships.network.C2SUpdateMovement;

public class FlyshipEntity extends Entity {

   public static final int MAX_PASSENGERS = 1;

   private PressedKey keys;

   private static final TrackedData<Integer> MOVEMENT_TYPE = DataTracker.registerData(FlyshipEntity.class,
         TrackedDataHandlerRegistry.INTEGER);

   private static final TrackedData<Boolean> FORWARD = DataTracker.registerData(FlyshipEntity.class,
         TrackedDataHandlerRegistry.BOOLEAN);
   private static final TrackedData<Boolean> BACKWARD = DataTracker.registerData(FlyshipEntity.class,
         TrackedDataHandlerRegistry.BOOLEAN);
   private static final TrackedData<Boolean> LEFT = DataTracker.registerData(FlyshipEntity.class,
         TrackedDataHandlerRegistry.BOOLEAN);
   private static final TrackedData<Boolean> RIGHT = DataTracker.registerData(FlyshipEntity.class,
         TrackedDataHandlerRegistry.BOOLEAN);
   private static final TrackedData<Boolean> UP = DataTracker.registerData(FlyshipEntity.class,
         TrackedDataHandlerRegistry.BOOLEAN);
   private static final TrackedData<Boolean> DOWN = DataTracker.registerData(FlyshipEntity.class,
         TrackedDataHandlerRegistry.BOOLEAN);

   public FlyshipEntity(EntityType<? extends Entity> entityType, World world) {
      super(entityType, world);
      this.keys = new PressedKey();
      this.inanimate = true;
   }

   public FlyshipEntity(World world, double x, double y, double z) {
      this(ModularFlyships.MODULAR_FLYSHIP, world);
      this.updatePosition(x, y, z);
      this.setVelocity(Vec3d.ZERO);
      this.prevX = x;
      this.prevY = y;
      this.prevZ = z;
   }

   @Override
   protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
      return dimensions.height;
   }

   protected void initDataTracker() {
      this.dataTracker.startTracking(MOVEMENT_TYPE, EnumMovementMode.STANDARD.ordinal());

      this.dataTracker.startTracking(FORWARD, false);
      this.dataTracker.startTracking(BACKWARD, false);
      this.dataTracker.startTracking(LEFT, false);
      this.dataTracker.startTracking(RIGHT, false);
      this.dataTracker.startTracking(UP, false);
      this.dataTracker.startTracking(DOWN, false);
   }

   public void updateDataTrackers() {
      this.dataTracker.set(MOVEMENT_TYPE, this.keys.movementMode.ordinal());

      this.dataTracker.set(FORWARD, this.keys.forward);
      this.dataTracker.set(BACKWARD, this.keys.backward);
      this.dataTracker.set(LEFT, this.keys.left);
      this.dataTracker.set(RIGHT, this.keys.right);
      this.dataTracker.set(DOWN, this.keys.up);
   }

   // Collide with other entities
   public boolean method_30948() {
      return true;
   }

   @Override
   public boolean isPushable() {
      return false;
   }

   @Override
   protected Vec3d method_30633(Direction.Axis axis, class_5459.class_5460 arg) {
      return LivingEntity.method_31079(super.method_30633(axis, arg));
   }

   @Override
   public double getMountedHeightOffset() {
      return 0.15D;
   }

   @Override
   public boolean collides() {
      return !this.removed;
   }

   @Override
   public Direction getMovementDirection() {
      return this.getHorizontalFacing().rotateYClockwise();
   }

   public void tick() {
      super.tick();
      this.setCustomNameVisible(true);
      this.setCustomName(new LiteralText(this.keys.movementMode.name()));
      this.tickMovement();
      if (this.isLogicalSideForUpdatingMovement()) {
         this.updateTrackedPosition(this.getX(), this.getY(), this.getZ());
      }
      this.checkBlockCollision();
   }

   private void tickMovement() {
      // @TODO: check for driver
      if (!this.hasPassengers()) {
         this.updateControls(new PressedKey());
         return;
      }

      if (!isLogicalSideForUpdatingMovement()){
         this.setVelocity(Vec3d.ZERO);
         return;
      }

      if (this.keys.left) {
         this.yaw -= 1;
      }

      if (this.keys.right) {
         this.yaw += 1;
      }

      double fbspeed = this.keys.forward ? .5d : this.keys.backward ? -.5d : 0d;
      double udspeed = this.keys.up ? .5d : this.keys.down ? -.5d : 0d;
      switch (this.keys.movementMode) {
         case PLAYER_YAW:
            this.setRotation(this.getPrimaryPassenger().yaw, this.getPrimaryPassenger().pitch);
            this.setVelocity(fromPolar(this.pitch, this.yaw).multiply(fbspeed).add(0d, udspeed, 0d));
            break;

         default:
            this.setVelocity(fromPolar(this.pitch, this.yaw).multiply(fbspeed, 0d, fbspeed).add(0d, udspeed, 0d));
      }

      this.move(MovementType.SELF, this.getVelocity());
   }

   public static Vec3d fromPolar(float pitch, float yaw) {
      float f = MathHelper.cos(-yaw * 0.017453292F - 3.1415927F);
      float g = MathHelper.sin(-yaw * 0.017453292F - 3.1415927F);
      float h = -MathHelper.cos(-pitch * 0.017453292F);
      float i = MathHelper.sin(-pitch * 0.017453292F);
      return new Vec3d((double)(g * h), (double)i, (double)(f * h));
   }

   public void updateControls(PressedKey pk) {
      boolean requiresUpdate = pk.forward != this.keys.forward
                               || pk.backward != this.keys.backward
                               || pk.left != this.keys.left
                               || pk.right != this.keys.right
                               || pk.up != this.keys.up
                               || pk.down != this.keys.down;

      this.keys = pk;
      this.updateDataTrackers();

      if (this.world.isClient && requiresUpdate) {
         ClientSidePacketRegistry.INSTANCE.sendToServer(C2SUpdateMovement.ID, pk.toPacket());
      }
   }

   protected void writeCustomDataToTag(CompoundTag tag) { }

   protected void readCustomDataFromTag(CompoundTag tag) { }

   public ActionResult interact(PlayerEntity player, Hand hand) {
      if (player.shouldCancelInteraction()) {
         return ActionResult.SUCCESS;
      } else {
         if (!this.world.isClient) {
            return player.startRiding(this) ? ActionResult.CONSUME : ActionResult.PASS;
         } else {
            return ActionResult.SUCCESS;
         }
      }
   }

   @Override
   public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
      // Default behaviour for entity is to pass down all damages to the passengers
      return false;
   }

   @Override
   protected boolean canAddPassenger(Entity passenger) {
      return this.getPassengerList().size() < MAX_PASSENGERS;
   }

   @Nullable
   @Override
   public Entity getPrimaryPassenger() {
      List<Entity> list = this.getPassengerList();
      return list.isEmpty() ? null : (Entity)list.get(0);
   }

   @Override
   public boolean canUsePortals() {
      return false;
   }

   @Override
   public Packet<?> createSpawnPacket() {
      return new EntitySpawnS2CPacket(this);
   }

}

