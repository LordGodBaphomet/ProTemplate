package alchemistmod.cards;

import alchemistmod.util.ConsumeActionTarget;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static alchemistmod.ModFile.makeID;
import static alchemistmod.util.Wiz.atb;
import static alchemistmod.util.Wiz.att;

public class Phlegm extends AbstractHumourCard implements ConsumeActionTarget {
    public final static String ID = makeID("Phlegm");
    // intellij stuff skill, self, basic, , ,  5, 3, ,
    public Phlegm() {
        this(0);
    }

    public Phlegm(int level) {
        super(ID, 1, CardRarity.SPECIAL, CardTarget.NONE);
        baseMagicNumber = 4;
        baseSecondMagic = 2;
        for (int i = 0; i < level; i++) {
            upgrade();
        }
        this.exhaust = true;
        tags.add(CustomTags.PHLEGM);
        consumePriority = level+1; 
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (this.timesUpgraded > 0) {
            atb(new MakeTempCardInDrawPileAction(new Phlegm(this.timesUpgraded-1), 1, true, true));
        }
    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
        upgradeSecondMagic(1);
    }

    @Override
    public void onConsume() {
        att(new ExhaustSpecificCardAction(this, new CardGroup(CardGroup.CardGroupType.HAND), true));
    }
}