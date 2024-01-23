package wibblywitch.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import wibblywitch.WibblyWitchMod;
import wibblywitch.character.WibblyWitch;

@SpirePatch(clz=AbstractOrb.class, method=SpirePatch.CLASS)
public class IsPrimaryFieldPatch {
    public static SpireField<Boolean> isPrimary = new SpireField<>(() -> false);
}
