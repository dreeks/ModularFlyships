package xyz.dreeks.modularflyships.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import xyz.dreeks.modularflyships.ModularFlyships;
import xyz.dreeks.modularflyships.client.model.FlyshipModel;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;

@Environment(EnvType.CLIENT)
public class FlyshipRenderer extends EntityRenderer<FlyshipEntity> {

   protected final FlyshipModel model = new FlyshipModel();

   public FlyshipRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher);
      this.shadowRadius = 0.8F;
   }

   @Override
   public void render(FlyshipEntity e, float f, float g, MatrixStack matrixStack,
         VertexConsumerProvider vertexConsumerProvider, int i) {
      matrixStack.push();
      matrixStack.translate(0.0D, 1.375D, 0.0D);
      // matrixStack.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(180.0F - f));

      matrixStack.scale(-1.0F, -1.0F, 1.0F);
      matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180.0F));
      matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(e.yaw));
      matrixStack.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(e.pitch));
      this.model.setAngles(e, g, 0.0F, -0.1F, 0.0F, 0.0F);
      VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(e)));
      this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

      matrixStack.pop();
      super.render(e, f, g, matrixStack, vertexConsumerProvider, i);
   }

   @Override
   protected void renderLabelIfPresent(FlyshipEntity entity, Text text, MatrixStack matrices,
         VertexConsumerProvider vertexConsumers, int light) {
      double d = this.dispatcher.getSquaredDistanceToCamera(entity);
      if (d <= 4096.0D) {
         boolean bl = !entity.isSneaky();
         float f = entity.getHeight() + 0.5F;
         int i = -20;
         matrices.push();
         matrices.translate(0.0D, (double) f, 0.0D);
         matrices.multiply(this.dispatcher.getRotation());
         matrices.scale(-0.025F, -0.025F, 0.025F);
         Matrix4f matrix4f = matrices.peek().getModel();
         float g = MinecraftClient.getInstance().options.getTextBackgroundOpacity(0.25F);
         int j = ((int) (g * 255.0F) << 24) + (int)(255 << 18);
         TextRenderer textRenderer = this.getFontRenderer();
         float h = (float) (-textRenderer.getWidth((StringVisitable) text) / 2);
         textRenderer.draw(text, h, (float) i, 553648127, false, matrix4f, vertexConsumers, bl, j, light);
         if (bl) {
            textRenderer.draw((Text) text, h, (float) i, -1, false, matrix4f, vertexConsumers, false, 0, light);
         }

         matrices.pop();
      }
   }

   @Override
   public Identifier getTexture(FlyshipEntity entity) {
      return new Identifier(ModularFlyships.MOD_NAME, "textures/entity/flyship/flyship.png");
   }
}