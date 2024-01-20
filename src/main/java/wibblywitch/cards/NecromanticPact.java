package wibblywitch.cards;

import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.actions.SpellQuickenAction;
import wibblywitch.cards.spellcards.AbstractSpellCard;
import wibblywitch.character.WibblyWitch;
import wibblywitch.util.CardStats;

public class NecromanticPact extends BaseCard {
    public static final String ID = makeID(NecromanticPact.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    );

    public NecromanticPact() {
        super(ID, info);
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster abstractMonster) {
        addToBot(new LoseHPAction(p, p, 2));
        addToBot(new SpellQuickenAction(p, 2));
    }

    @Override
    public AbstractCard makeCopy() {
        return new NecromanticPact();
    }
}
