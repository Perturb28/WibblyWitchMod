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

public class EssentialSpellPower extends AbstractPower implements InvisiblePower {
    private static PowerStrings getPowerStrings(String ID)
    {
        return CardCrawlGame.languagePack.getPowerStrings(ID);
    }
    protected AbstractCreature source;
    protected String[] DESCRIPTIONS;

    public EssentialSpellPower(AbstractCreature c) {
        this.ID = makeID("EssentialSpellPower");
        PowerStrings strings = getPowerStrings(this.ID);
        this.name = strings.NAME;
        this.DESCRIPTIONS = strings.DESCRIPTIONS;
        this.owner = c;
        this.source = c;
        this.type = NEUTRAL;
    }

    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        addToBot(new SpellQuickenAction(AbstractDungeon.player, 1));
    }
}
