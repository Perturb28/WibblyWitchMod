package wibblywitch.powers;

import basemod.interfaces.OnStartBattleSubscriber;
import com.evacipated.cardcrawl.mod.stslib.patches.NeutralPowertypePatch;
import com.evacipated.cardcrawl.mod.stslib.patches.bothInterfaces.OnReceivePowerPatch;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.InvisiblePower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import wibblywitch.WibblyWitchMod;
import wibblywitch.actions.SpellQuickenAction;

import static com.evacipated.cardcrawl.mod.stslib.patches.NeutralPowertypePatch.NEUTRAL;
import static wibblywitch.WibblyWitchMod.makeID;

public class SpellTickPower extends BasePower implements InvisiblePower {
    public static final String POWER_ID = makeID("SpellTick");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;

    public SpellTickPower(AbstractCreature c) {
        super(POWER_ID, TYPE, false, c, 1);
    }

    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        addToBot(new SpellQuickenAction(AbstractDungeon.player, 1));
    }
}
