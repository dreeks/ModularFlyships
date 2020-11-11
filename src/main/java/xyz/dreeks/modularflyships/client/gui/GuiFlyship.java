package xyz.dreeks.modularflyships.client.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.LiteralText;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;

@Environment(EnvType.CLIENT)
public class GuiFlyship extends LightweightGuiDescription {

    public GuiFlyship(FlyshipEntity fe) {
        WGridPanel root = new WGridPanel();
        this.setRootPanel(root);

        root.setSize(256, 240);

        WButton wb = new WButton(new LiteralText("Change mode"));
        wb.setOnClick(() -> {
            System.out.println("Toto");
        });

        root.add(wb, 0, 0);

        root.validate(this);
    }

    
}
