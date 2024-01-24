package wibblywitch.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import wibblywitch.actions.SpellIntensifyAction;
import wibblywitch.actions.SpellQuickenAction;

import static com.evacipated.cardcrawl.mod.stslib.patches.NeutralPowertypePatch.NEUTRAL;
import static com.megacrit.cardcrawl.powers.AbstractPower.PowerType.BUFF;
import static wibblywitch.WibblyWitchMod.makeID;

public class IntensifyPower extends BasePower {
    public static final String POWER_ID = makeID("Intensify");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public IntensifyPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    public void atStartOfTurn() {
        this.flash();
        this.addToBot(new SpellIntensifyAction());
    }
}
