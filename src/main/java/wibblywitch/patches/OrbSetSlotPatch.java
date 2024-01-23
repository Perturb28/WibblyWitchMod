package wibblywitch.patches;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import wibblywitch.WibblyWitchMod;
import wibblywitch.character.WibblyWitch;

import static com.megacrit.cardcrawl.core.Settings.scale;

@SpirePatch2(clz = AbstractOrb.class, method = "setSlot")
public class OrbSetSlotPatch {

    @SpirePostfixPatch
    public static void Postfix(AbstractOrb __instance, int slotNum) {

        if (AbstractDungeon.player instanceof WibblyWitch) {
            IsPrimaryFieldPatch.isPrimary.set(__instance, true);
            float xStartOffset = AbstractDungeon.player.drawX + 50F;
            float yStartOffset = AbstractDungeon.player.drawY + scale * 300F;

            __instance.tX = xStartOffset;
            __instance.tY = yStartOffset;
            if (slotNum == 1) {
                IsPrimaryFieldPatch.isPrimary.set(__instance, false);
                __instance.tX -= scale * 100F;
                __instance.tY += scale * 50F;
            }

            __instance.hb.move(__instance.tX, __instance.tY);
        }
    }
}