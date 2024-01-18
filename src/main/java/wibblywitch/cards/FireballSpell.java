package wibblywitch.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.character.WibblyWitch;
import wibblywitch.util.CardStats;

import static wibblywitch.WibblyWitchMod.makeID;

public class FireballSpell extends BaseCard{
    public static final String ID = makeID(FireballSpell.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.COLORLESS,
            AbstractCard.CardType.STATUS,
            AbstractCard.CardRarity.SPECIAL,
            AbstractCard.CardTarget.NONE,
            0
    );

    public FireballSpell() {
        super(ID, info);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
    }

    public AbstractCard makeCopy() {
        return new FireballSpell();
    }
}
