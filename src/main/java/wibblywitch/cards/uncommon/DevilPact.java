package wibblywitch.cards.uncommon;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.actions.SpellQuickenAction;
import wibblywitch.cards.BaseCard;
import wibblywitch.character.WibblyWitch;
import wibblywitch.util.CardStats;

@NoCompendium
public class DevilPact extends BaseCard {
    public static final String ID = makeID(DevilPact.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            0
    );

    public DevilPact() {
        super(ID, info);
        this.exhaust = true;
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster abstractMonster) {
        addToBot(new LoseHPAction(p, p, 2));
        addToBot(new SpellQuickenAction(p, 1));
        this.addToTop(new MakeTempCardInHandAction(this.makeStatEquivalentCopy()));
    }

    @Override
    public AbstractCard makeCopy() {
        return new DevilPact();
    }
}
