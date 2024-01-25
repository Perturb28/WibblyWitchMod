package wibblywitch.orbs;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import wibblywitch.actions.CometsEvokeAction;
import wibblywitch.actions.DustEvokeAction;

import static wibblywitch.WibblyWitchMod.makeID;

public class CometsOrb extends AbstractSpellOrb{
    public static final String ID = makeID("CometsOrb");
    private static final OrbStrings orbStrings = CardCrawlGame.languagePack.getOrbString(ID);

    private final static int BASE_DELAY = 2;
    public final static int BASE_DAMAGE = 6;
    public final static int BASE_COUNT = 3;
    private int count = BASE_COUNT;

    public CometsOrb() {
        super(BASE_DELAY);
        this.name = orbStrings.NAME;
        this.img = COMETS_IMG;
        this.updateDescription();
    }
    @Override
    public void updateDescription() {
        super.updateDescription();
        this.description += orbStrings.DESCRIPTION[0] + BASE_DAMAGE + orbStrings.DESCRIPTION[1] + this.count + orbStrings.DESCRIPTION[2];
        this.description += orbStrings.DESCRIPTION[3];
    }

    @Override
    public void onEvoke() {
        AbstractDungeon.actionManager.addToTop(new CometsEvokeAction(this.count));
    }

    @Override
    public void intensify() {
        this.count += 1;
        updateDescription();
    }

    @Override
    public AbstractOrb makeCopy() {
        return new CometsOrb();
    }
}
