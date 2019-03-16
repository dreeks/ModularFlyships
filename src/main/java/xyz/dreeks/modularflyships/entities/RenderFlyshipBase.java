package xyz.dreeks.modularflyships.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.dreeks.modularflyships.utils.Constants;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP;

public class RenderFlyshipBase extends Render<EntityFlyshipBase> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Constants.MOD_ID + ":textures/entities/flyship_base.png");

    public RenderFlyshipBase(RenderManager manager) {
        super(manager);
    }

    @Override
    public void doRender(EntityFlyshipBase entity, double x, double y, double z, float entityYaw, float partialTicks) {
        drawSquare(x, y + 1, z, 1f, 1f, 1f, 1f);
        drawSquare(x, y + 1.5, z, 1f, 0f, 0f, 1f);
        drawSquare(x, y + 2, z, 0f, 1f, 0f, 1f);
        drawSquare(x, y + 2.5, z, 0f, 0f, 1f, 1f);
    }

    static void drawSquare(double x, double y, double z, float r, float g, float b, float a) {
        GlStateManager.pushMatrix();

        GlStateManager.popMatrix();
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityFlyshipBase e) {
        return TEXTURES;
    }

}
