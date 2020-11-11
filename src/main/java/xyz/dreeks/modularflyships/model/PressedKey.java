package xyz.dreeks.modularflyships.model;

import io.netty.buffer.Unpooled;
import net.minecraft.client.input.Input;
import net.minecraft.network.PacketByteBuf;

public class PressedKey {

    public EnumMovementMode movementMode;
    public boolean forward, backward, left, right, up, down;
    
    public PressedKey() {
        this.movementMode = EnumMovementMode.STANDARD;
    }

    public PressedKey(Input i, boolean down) {
        this(i, down, EnumMovementMode.STANDARD);
    }

    public PressedKey(Input i, boolean down, EnumMovementMode mm) {
        this.forward = i.pressingForward;
        this.backward = i.pressingBack;
        this.left = i.pressingLeft;
        this.right = i.pressingRight;
        this.up = i.jumping;
        this.down = down;

        this.movementMode = mm;
    }

    public PressedKey(PacketByteBuf pbb) {
        this.movementMode = EnumMovementMode.values()[pbb.readInt()];

        this.forward  = pbb.readBoolean();
        this.backward = pbb.readBoolean();
        this.left     = pbb.readBoolean();
        this.right    = pbb.readBoolean();
        this.up       = pbb.readBoolean();
        this.down     = pbb.readBoolean();
    }

    public PressedKey setForward(boolean b) {
        this.forward = b;
        return this;
    }

    public PressedKey setBackward(boolean b) {
        this.backward = b;
        return this;
    }

    public PressedKey setLeft(boolean b) {
        this.left = b;
        return this;
    }

    public PressedKey setRight(boolean b) {
        this.right = b;
        return this;
    }

    public PressedKey setUp(boolean b) {
        this.up = b;
        return this;
    }

    public PressedKey setDown(boolean b) {
        this.down = b;
        return this;
    }

    public PressedKey setMovementMode(EnumMovementMode mm) {
        this.movementMode = mm;
        return this;
    }

    public void cycleMovementMode() {
        int curr = this.movementMode.ordinal() + 1;
        if (curr >= EnumMovementMode.values().length) {
            curr -= EnumMovementMode.values().length;
        }

        this.movementMode = EnumMovementMode.values()[curr];
    }

    public PacketByteBuf toPacket() {
        PacketByteBuf pbb = new PacketByteBuf(Unpooled.buffer());

        pbb.writeInt(this.movementMode.ordinal());

        pbb.writeBoolean(this.forward);
        pbb.writeBoolean(this.backward);
        pbb.writeBoolean(this.left);
        pbb.writeBoolean(this.right);
        pbb.writeBoolean(this.up);
        pbb.writeBoolean(this.down);

        return pbb;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PressedKey))
            return false;

        if (o == this) {
            return true;
        }

        PressedKey pk = (PressedKey)o;

        return pk.forward == this.forward
            && pk.backward == this.backward
            && pk.left == this.left
            && pk.right == this.right
            && pk.up == this.up
            && pk.down == this.down
            && pk.movementMode == this.movementMode;
    }

    @Override
    public String toString() {
        String s = "PressedKeys: ";

        s += this.forward ? "F" : "-";
        s += this.backward ? "B" : "-";
        s += this.left ? "L" : "-";
        s += this.right ? "R" : "-";
        s += this.up ? "U" : "-";
        s += this.down ? "D" : "-";

        s += " Movement: " + this.movementMode.name();

        return s;
    }

}
