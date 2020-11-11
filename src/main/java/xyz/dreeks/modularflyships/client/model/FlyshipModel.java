package xyz.dreeks.modularflyships.client.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;

public class FlyshipModel extends EntityModel<FlyshipEntity> {
    private final ModelPart keyboard_support;
    private final ModelPart keyboard;
    private final ModelPart top_cables;
    private final ModelPart wing_side_connector_left;
    private final ModelPart wing_left;
    private final ModelPart wing_side_connector_right;
    private final ModelPart wing_right;
    private final ModelPart bone;
    private final ModelPart reakktor;
    private final ModelPart shell;
    private final ModelPart addon_left;
    private final ModelPart addon_right;
    private final ModelPart addon_air;
    private final ModelPart seat;
    private final ModelPart seat_bottom;
    private final ModelPart chrome_ring;
    private final ModelPart base;

    public FlyshipModel() {
        textureWidth = 512;
        textureHeight = 512;
        keyboard_support = new ModelPart(this);
        keyboard_support.setPivot(0.0F, 24.0F, 0.0F);
        keyboard_support.setTextureOffset(472, 166).addCuboid(-9.0F, -12.0F, -12.0F, 18.0F, 2.0F, 2.0F, 0.0F, true);
        keyboard_support.setTextureOffset(484, 149).addCuboid(9.0F, -12.0F, -12.0F, 1.0F, 2.0F, 13.0F, 0.0F, true);
        keyboard_support.setTextureOffset(484, 149).addCuboid(-10.0F, -12.0F, -12.0F, 1.0F, 2.0F, 13.0F, 0.0F, true);

        keyboard = new ModelPart(this);
        keyboard.setPivot(0.0F, 7.0F, -14.0F);
        setRotationAngle(keyboard, -0.6109F, 0.0F, 0.0F);
        keyboard.setTextureOffset(464, 140).addCuboid(-9.0F, 2.2766F, 2.2943F, 18.0F, 1.0F, 6.0F, 0.0F, true);

        top_cables = new ModelPart(this);
        top_cables.setPivot(0.0F, -1.0F, 8.0F);
        setRotationAngle(top_cables, -0.3944F, 0.0F, 0.0F);
        top_cables.setTextureOffset(458, 0).addCuboid(-7.0F, 3.6928F, 1.5372F, 14.0F, 5.0F, 13.0F, 0.0F, true);

        wing_side_connector_left = new ModelPart(this);
        wing_side_connector_left.setPivot(10.0F, 12.0F, 10.5F);
        setRotationAngle(wing_side_connector_left, 0.0F, 0.0F, 2.3562F);
        wing_side_connector_left.setTextureOffset(296, 21).addCuboid(0.8284F, -4.8284F, -8.5F, 4.0F, 4.0F, 17.0F, 0.0F,
                true);

        wing_left = new ModelPart(this);
        wing_left.setPivot(10.0F, 12.0F, 3.0F);
        setRotationAngle(wing_left, 0.0F, 0.0F, 0.3491F);
        wing_left.setTextureOffset(324, 62).addCuboid(1.3681F, 2.7588F, 0.0F, 5.0F, 1.0F, 15.0F, 0.0F, true);
        wing_left.setTextureOffset(268, 45).addCuboid(6.3681F, 1.7588F, -16.0F, 9.0F, 3.0F, 36.0F, 0.0F, false);
        wing_left.setTextureOffset(242, 51).addCuboid(1.3681F, 1.7588F, -27.0F, 9.0F, 3.0F, 17.0F, 0.0F, false);
        wing_left.setTextureOffset(205, 46).addCuboid(-3.6319F, 1.7588F, -38.0F, 9.0F, 3.0F, 17.0F, 0.0F, false);
        wing_left.setTextureOffset(196, 24).addCuboid(-5.6319F, 1.7588F, -46.0F, 6.0F, 3.0F, 17.0F, 0.0F, false);
        wing_left.setTextureOffset(155, 11).addCuboid(-7.6319F, 1.7588F, -54.0F, 3.0F, 3.0F, 25.0F, 0.0F, false);
        wing_left.setTextureOffset(286, 86).addCuboid(15.3681F, 1.7588F, -9.0F, 3.0F, 3.0F, 24.0F, 0.0F, false);

        wing_side_connector_right = new ModelPart(this);
        wing_side_connector_right.setPivot(-10.0F, 12.0F, 10.5F);
        setRotationAngle(wing_side_connector_right, 0.0F, 0.0F, -0.7854F);
        wing_side_connector_right.setTextureOffset(296, 21).addCuboid(-4.8284F, 0.8284F, -8.5F, 4.0F, 4.0F, 17.0F, 0.0F,
                true);

        wing_right = new ModelPart(this);
        wing_right.setPivot(-10.0F, 12.0F, 3.0F);
        setRotationAngle(wing_right, 0.0F, 0.0F, -0.3491F);
        wing_right.setTextureOffset(324, 62).addCuboid(-6.3681F, 2.7588F, 0.0F, 5.0F, 1.0F, 15.0F, 0.0F, true);
        wing_right.setTextureOffset(268, 45).addCuboid(-15.3681F, 1.7588F, -16.0F, 9.0F, 3.0F, 36.0F, 0.0F, true);
        wing_right.setTextureOffset(242, 51).addCuboid(-10.3681F, 1.7588F, -27.0F, 9.0F, 3.0F, 17.0F, 0.0F, true);
        wing_right.setTextureOffset(205, 46).addCuboid(-5.3681F, 1.7588F, -38.0F, 9.0F, 3.0F, 17.0F, 0.0F, true);
        wing_right.setTextureOffset(196, 24).addCuboid(-0.3681F, 1.7588F, -46.0F, 6.0F, 3.0F, 17.0F, 0.0F, true);
        wing_right.setTextureOffset(155, 11).addCuboid(4.6319F, 1.7588F, -54.0F, 3.0F, 3.0F, 25.0F, 0.0F, true);
        wing_right.setTextureOffset(286, 86).addCuboid(-18.3681F, 1.7588F, -9.0F, 3.0F, 3.0F, 24.0F, 0.0F, true);

        bone = new ModelPart(this);
        bone.setPivot(-1.0F, -2.0F, -22.0F);
        wing_right.addChild(bone);
        setRotationAngle(bone, 1.5708F, 0.0F, 0.0F);
        bone.setTextureOffset(181, 86).addCuboid(-2.3681F, -16.0F, -3.7588F, 1.0F, 16.0F, 1.0F, 0.0F, true);
        bone.setTextureOffset(155, 86).addCuboid(-1.3681F, -16.0F, -3.7588F, 11.0F, 8.0F, 1.0F, 0.0F, true);

        reakktor = new ModelPart(this);
        reakktor.setPivot(0.0F, 24.0F, 0.0F);
        reakktor.setTextureOffset(460, 93).addCuboid(-6.0F, -15.0F, 22.0F, 12.0F, 12.0F, 14.0F, 0.0F, true);
        reakktor.setTextureOffset(478, 121).addCuboid(-7.0F, -16.0F, 25.0F, 14.0F, 14.0F, 3.0F, 0.0F, true);
        reakktor.setTextureOffset(478, 121).addCuboid(-7.0F, -16.0F, 31.0F, 14.0F, 14.0F, 3.0F, 0.0F, true);

        shell = new ModelPart(this);
        shell.setPivot(0.0F, 24.0F, 0.0F);
        shell.setTextureOffset(438, 20).addCuboid(-9.0F, -16.0F, 3.0F, 18.0F, 14.0F, 19.0F, 0.0F, true);
        shell.setTextureOffset(322, 0).addCuboid(-10.0F, -12.0F, 9.0F, 20.0F, 8.0F, 11.0F, 0.0F, true);
        shell.setTextureOffset(296, 0).addCuboid(6.0F, -12.0F, 1.0F, 4.0F, 10.0F, 8.0F, 0.0F, false);
        shell.setTextureOffset(296, 0).addCuboid(-10.0F, -12.0F, 1.0F, 4.0F, 10.0F, 8.0F, 0.0F, true);

        addon_left = new ModelPart(this);
        addon_left.setPivot(9.0F, -5.0F, 6.5F);
        shell.addChild(addon_left);
        setRotationAngle(addon_left, 0.0F, 0.0F, 0.8727F);
        addon_left.setTextureOffset(340, 131).addCuboid(-8.0F, -8.0F, 0.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        addon_right = new ModelPart(this);
        addon_right.setPivot(-4.0F, -11.0F, 6.5F);
        shell.addChild(addon_right);
        setRotationAngle(addon_right, 0.0F, 0.0F, -0.8727F);
        addon_right.setTextureOffset(376, 131).addCuboid(-8.0F, -8.0F, 0.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        addon_air = new ModelPart(this);
        addon_air.setPivot(0.0F, 0.0F, 0.0F);
        shell.addChild(addon_air);
        addon_air.setTextureOffset(496, 174).addCuboid(-14.0F, -19.0F, 19.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);
        addon_air.setTextureOffset(486, 183).addCuboid(-12.5F, -20.0F, 20.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        addon_air.setTextureOffset(484, 177).addCuboid(-13.5F, -21.0F, 20.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        seat = new ModelPart(this);
        seat.setPivot(0.0F, 24.0F, 0.0F);
        seat.setTextureOffset(402, 36).addCuboid(-6.0F, -20.0F, 2.0F, 12.0F, 12.0F, 5.0F, 0.0F, true);
        seat.setTextureOffset(396, 73).addCuboid(-6.0F, -6.0F, -7.0F, 12.0F, 4.0F, 8.0F, 0.0F, true);

        seat_bottom = new ModelPart(this);
        seat_bottom.setPivot(0.0F, -10.0F, -7.0F);
        seat.addChild(seat_bottom);
        setRotationAngle(seat_bottom, 0.2443F, 0.0F, 0.0F);
        seat_bottom.setTextureOffset(386, 55).addCuboid(-6.0F, 3.8812F, -0.9677F, 12.0F, 3.0F, 13.0F, 0.0F, true);

        chrome_ring = new ModelPart(this);
        chrome_ring.setPivot(0.0F, 0.0F, 0.0F);
        seat.addChild(chrome_ring);
        chrome_ring.setTextureOffset(422, 0).addCuboid(-7.0F, -21.0F, 5.0F, 14.0F, 5.0F, 3.0F, 0.0F, true);
        chrome_ring.setTextureOffset(390, 92).addCuboid(-7.0F, -4.0F, -8.0F, 14.0F, 2.0F, 9.0F, 0.0F, true);

        base = new ModelPart(this);
        base.setPivot(0.0F, 24.0F, 0.0F);
        base.setTextureOffset(417, 66).addCuboid(-9.0F, -2.0F, -11.0F, 18.0F, 2.0F, 22.0F, 0.0F, true);
        base.setTextureOffset(412, 131).addCuboid(-6.0F, 0.0F, -6.0F, 12.0F, 3.0F, 12.0F, 0.0F, false);
    }

    @Override
    public void setAngles(FlyshipEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch) {
        // previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red,
            float green, float blue, float alpha) {

        keyboard_support.render(matrixStack, buffer, packedLight, packedOverlay);
        keyboard.render(matrixStack, buffer, packedLight, packedOverlay);
        top_cables.render(matrixStack, buffer, packedLight, packedOverlay);
        wing_side_connector_left.render(matrixStack, buffer, packedLight, packedOverlay);
        wing_left.render(matrixStack, buffer, packedLight, packedOverlay);
        wing_side_connector_right.render(matrixStack, buffer, packedLight, packedOverlay);
        wing_right.render(matrixStack, buffer, packedLight, packedOverlay);
        reakktor.render(matrixStack, buffer, packedLight, packedOverlay);
        shell.render(matrixStack, buffer, packedLight, packedOverlay);
        seat.render(matrixStack, buffer, packedLight, packedOverlay);
        base.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

}
