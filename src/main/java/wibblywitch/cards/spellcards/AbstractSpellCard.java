package wibblywitch.cards.spellcards;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.cards.BaseCard;
import wibblywitch.character.WibblyWitch;
import wibblywitch.util.CardStats;

import static wibblywitch.WibblyWitchMod.characterPath;

@NoCompendium
public class AbstractSpellCard extends BaseCard {
    public static final String ID = makeID(AbstractSpellCard.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.SPECIAL,
            AbstractCard.CardTarget.NONE,
            -2
    );
    public AbstractSpellCard() {
        // This shouldn't ever happen, it's just here to make the game happy.
        super(ID, info);
    }

    public AbstractSpellCard(String newID) {
        super(newID, info);
        // Spell cards can use unique backgrounds!
        setBackgroundTexture(characterPath("cardback/bg_attack.png"), characterPath("cardback/bg_attack_p.png"));
    }

    @Override
    public void render(SpriteBatch sb) {
        // Cursed solution, avert your eyes.
        String oldText = TEXT[1];
        TEXT[1] = "Spell";
        if (!Settings.hideCards) {
            this.render(sb, false);
        }
        TEXT[1] = oldText;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
    }

    public AbstractCard makeCopy() {
        return new AbstractSpellCard(ID);
    }
}
