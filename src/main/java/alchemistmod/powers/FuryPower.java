package alchemistmod.powers;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static alchemistmod.ModFile.makeID;

public class FuryPower extends AbstractEasyPower {
    public static final String NAME = "Fury";
    public static final String POWER_ID = makeID("FuryPower");
    public static final PowerType POWER_TYPE = PowerType.BUFF;
    public static final boolean IS_TURN_BASED = true;

    public FuryPower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, POWER_TYPE, IS_TURN_BASED, owner, amount);
    }

    @Override
    public void updateDescription() {
        if (this.amount == 1) {
            this.description = DESCRIPTIONS[0];
        } else {
            this.description = DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
        }
    }

    @Override
    public float atDamageGive(float damage, DamageInfo.DamageType type) {
        flashWithoutSound();
        if (type == DamageInfo.DamageType.NORMAL) {
            damage += this.amount;
            this.reducePower(2);
        }
        return damage;
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if (this.amount > 0) {
            this.reducePower(2);
        }
    }

    @Override
    public void reducePower(int reduceAmount) {
        if (amount - reduceAmount < 0){
            this.amount = 0;
        } else {
            this.amount -= reduceAmount;
        }
    }
}
