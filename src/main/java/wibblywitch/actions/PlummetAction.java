package wibblywitch.actions;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.combat.MiracleEffect;

import java.util.ArrayList;

public class PlummetAction extends AbstractGameAction {
    public PlummetAction() {
    }

    public void update() {
        // Give energy back if the card played previously was a skill.
        ArrayList<AbstractCard> played = AbstractDungeon.actionManager.cardsPlayedThisCombat;
        if (played.size() >= 2 && (played.get(played.size() - 2)).type == AbstractCard.CardType.SKILL) {
            this.addToTop(new GainEnergyAction(1));
            if (Settings.FAST_MODE) {
                this.addToTop(new VFXAction(new MiracleEffect(Color.CYAN, Color.PURPLE, "ATTACK_MAGIC_SLOW_1"), 0.0F));
            } else {
                this.addToTop(new VFXAction(new MiracleEffect(Color.CYAN, Color.PURPLE, "ATTACK_MAGIC_SLOW_1"), 0.3F));
            }
        }

        this.isDone = true;
    }
}
