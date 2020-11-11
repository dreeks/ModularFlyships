package xyz.dreeks.modularflyships.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;

@Mixin(PlayerEntity.class)
public class Interact {

    @Inject(
			method = "interact(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;",
			at = @At(value = "HEAD"),
			cancellable = true,
			locals = LocalCapture.CAPTURE_FAILHARD
	)
    
   public void interact(CallbackInfoReturnable<ActionResult> cir, Entity entity, Hand hand) {

        if (!(entity instanceof FlyshipEntity)) {
            return;
        }

        FlyshipEntity fe = (FlyshipEntity)entity;
        if (!fe.world.isClient) {
            // @TODO: Send packet if correct owner
        }

   }
}
