package wibblywitch.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.InvisiblePower;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import wibblywitch.character.WibblyWitch;
import wibblywitch.orbs.SupernovaOrb;

import static wibblywitch.WibblyWitchMod.makeID;

public class SupernovaHitPower extends BasePower implements InvisiblePower {
    public static final String POWER_ID = makeID("SupernovaHit");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;

    public SupernovaHitPower(AbstractCreature c) {
        super(POWER_ID, TYPE, false, c, 1);
    }

    @Override
    public void onPlayCard(AbstractCard card, AbstractMonster m) {
        AbstractPlayer p = AbstractDungeon.player;
        if (p instanceof WibblyWitch) {
            if (p.orbs.get(0) instanceof SupernovaOrb && card.type == AbstractCard.CardType.ATTACK && card.cost >= 2) {
                ((SupernovaOrb) p.orbs.get(0)).intensify();
            }
        }
    }
}
