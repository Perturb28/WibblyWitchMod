package wibblywitch.patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import wibblywitch.WibblyWitchMod;
import wibblywitch.character.WibblyWitch;

@SpirePatch2(clz = EmptyOrbSlot.class, method = "render")
public class EmptyOrbSlotPatch {

    @SpireInsertPatch(rloc=1, localvars={"scale"})
    public static void Insert(AbstractOrb __instance, @ByRef float[] scale) {
        if (AbstractDungeon.player instanceof WibblyWitch) {
            if (IsPrimaryFieldPatch.isPrimary.get(__instance)) {
                scale[0] = 2;
            }
        }
    }
}
