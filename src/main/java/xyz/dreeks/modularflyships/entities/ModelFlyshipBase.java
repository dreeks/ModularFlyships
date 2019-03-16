package xyz.dreeks.modularflyships.entities;
//Made with Blockbench
//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlyshipBase extends ModelBase {

    private final ModelRenderer bone;

    public ModelFlyshipBase() {
        textureWidth = 16;
        textureHeight = 16;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -1.0F, -1.0F, 3, 1, 6, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 2, 0, -3.0F, -2.0F, -1.0F, 1, 1, 5, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 12, 0, 1.0F, -2.0F, -1.0F, 1, 1, 5, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 14, 0, -3.0F, -2.0F, 4.0F, 5, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 15, 0, -2.0F, -3.0F, 4.0F, 3, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 15, 0, -1.0F, -4.0F, 4.0F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 15, 0, -2.0F, -2.0F, -2.0F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 15, 0, 0.0F, -2.0F, -2.0F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 15, 0, -1.0F, -1.0F, -2.0F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 15, 0, -1.0F, -2.0F, -3.0F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 15, 0, -1.0F, -3.0F, 5.0F, 1, 3, 1, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        bone.render(f5);
    }
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
