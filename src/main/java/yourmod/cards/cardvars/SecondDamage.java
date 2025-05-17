package yourmod.cards.cardvars;

import com.megacrit.cardcrawl.cards.AbstractCard;
import yourmod.cards.AbstractReptoCard;

import static yourmod.ModFile.makeID;

public class SecondDamage extends AbstractEasyDynamicVariable {

    @Override
    public String key() {
        return makeID("sd");
    }

    @Override
    public boolean isModified(AbstractCard card) {
        if (card instanceof AbstractReptoCard) {
            return ((AbstractReptoCard) card).isSecondDamageModified;
        }
        return false;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof AbstractReptoCard) {
            ((AbstractReptoCard) card).isSecondDamageModified = v;
        }
    }

    @Override
    public int value(AbstractCard card) {
        if (card instanceof AbstractReptoCard) {
            return ((AbstractReptoCard) card).secondDamage;
        }
        return -1;
    }

    @Override
    public int baseValue(AbstractCard card) {
        if (card instanceof AbstractReptoCard) {
            return ((AbstractReptoCard) card).baseSecondDamage;
        }
        return -1;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        if (card instanceof AbstractReptoCard) {
            return ((AbstractReptoCard) card).upgradedSecondDamage;
        }
        return false;
    }
}