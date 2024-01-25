package wibblywitch.cards.rare;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.actions.spells.SpellPrepareAction;
import wibblywitch.cards.BaseCard;
import wibblywitch.cards.spellcards.SupernovaSpell;
import wibblywitch.character.WibblyWitch;
import wibblywitch.orbs.SupernovaOrb;
import wibblywitch.util.CardStats;

public class PrepareSupernova extends BaseCard {
    public static final String ID = makeID(PrepareSupernova.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.RARE,
            AbstractCard.CardTarget.ENEMY,
            2
    );

    public PrepareSupernova() {
        super(ID, info);
        this.cardsToPreview = new SupernovaSpell();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SpellPrepareAction(new SupernovaOrb(m)));
    }

    @Override
    public AbstractCard makeCopy() {
        return new PrepareSupernova();
    }
}
