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
    private final AbstractMonster m;

    private final static int INTENSIFY_DAMAGE = 5;
    private final static int BASE_DELAY = 2;
    public final static int BASE_DAMAGE = 20;
    private int damage;

    public DustOrb(AbstractMonster m) {
        super(BASE_DELAY);

        this.name = orbStrings.NAME;
        this.img = DUST_IMG;

        this.m = m;
        this.damage = BASE_DAMAGE;

        this.updateDescription();
    }

    @Override
    public void updateDescription() {
        super.updateDescription();
        this.description += orbStrings.DESCRIPTION[0] + this.damage + orbStrings.DESCRIPTION[1];
        this.description += orbStrings.DESCRIPTION[2] + INTENSIFY_DAMAGE + orbStrings.DESCRIPTION[3];
    }

    @Override
    public void onEvoke() {
        AbstractDungeon.actionManager.addToTop(new DustEvokeAction(this.damage, m));
    }

    @Override
    public void intensify() {
        this.damage += INTENSIFY_DAMAGE;
    }

    @Override
    public AbstractOrb makeCopy() {
        return new DustOrb(m);
    }
}
