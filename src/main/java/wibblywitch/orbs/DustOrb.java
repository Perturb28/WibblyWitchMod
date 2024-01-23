package wibblywitch.orbs;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import wibblywitch.WibblyWitchMod;
import wibblywitch.actions.DustEvokeAction;
import wibblywitch.actions.FireballEvokeAction;

import static wibblywitch.WibblyWitchMod.makeID;

public class DustOrb extends AbstractSpellOrb {


    public static final String ID = makeID("DustOrb");
    private static final OrbStrings orbStrings = CardCrawlGame.languagePack.getOrbString(ID);
    private AbstractMonster m;

    private final static int BASE_DELAY = 0;
    public final static int BASE_DAMAGE = 8;
    private int DAMAGE;

    public DustOrb(AbstractMonster m) {
        super(BASE_DELAY);

        this.name = orbStrings.NAME;
        this.img = DUST_IMG;

        this.m = m;
        this.DAMAGE = BASE_DAMAGE;

        this.updateDescription();
    }

    @Override
    public void updateDescription() {
        super.updateDescription();
        this.description += orbStrings.DESCRIPTION[0] + this.DAMAGE + orbStrings.DESCRIPTION[1];
    }

    @Override
    public void onEvoke() {
        AbstractDungeon.actionManager.addToTop(new DustEvokeAction(new DamageInfo(AbstractDungeon.player, this.DAMAGE, DamageInfo.DamageType.THORNS), m));
    }

    @Override
    public AbstractOrb makeCopy() {
        return new DustOrb(m);
    }
}
