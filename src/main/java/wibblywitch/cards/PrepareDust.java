package wibblywitch.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.actions.SpellPrepareAction;
import wibblywitch.cards.spellcards.DustSpell;
import wibblywitch.character.WibblyWitch;
import wibblywitch.orbs.DustOrb;
import wibblywitch.util.CardStats;

public class PrepareDust extends BaseCard {
    public static final String ID = makeID(PrepareDust.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            0
    );

    public PrepareDust() {
        super(ID, info);

        this.cardsToPreview = new DustSpell();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SpellPrepareAction(new DustOrb(m)));
    }

    @Override
    public AbstractCard makeCopy() {
        return new PrepareDust();
    }
}
