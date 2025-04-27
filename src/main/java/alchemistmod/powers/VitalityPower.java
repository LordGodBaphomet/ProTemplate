package alchemistmod.powers;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static alchemistmod.ModFile.makeID;

public class VitalityPower extends AbstractEasyPower implements HealthBarRenderPower {
    public static final String NAME = "Vitality";
    public static final String POWER_ID = makeID("VitalityPower");
    public static final PowerType POWER_TYPE = PowerType.BUFF;
    public static final boolean IS_TURN_BASED = false;
    public int maxAmount = 5;

    public VitalityPower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, POWER_TYPE, IS_TURN_BASED, owner, amount);
    }

    @Override
    public void stackPower(int stackAmount) {
        if (this.amount != maxAmount) {
            flashWithoutSound();
        }

        if (this.amount + stackAmount > maxAmount) {
            this.amount = maxAmount;
        } else {
            this.amount += stackAmount;
        }
    }

    @Override
    public void reducePower(int reduceAmount) {
        if (this.owner.hasPower(TumorIgnorePower.POWER_ID)) {
            this.owner.getPower(TumorIgnorePower.POWER_ID).flash();

            if (this.owner.getPower(TumorIgnorePower.POWER_ID).amount > 1) {
                addToBot(new ReducePowerAction(this.owner, this.owner, TumorIgnorePower.POWER_ID, 1));
            } else {
                addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, TumorIgnorePower.POWER_ID));
            }
        } else {
            this.amount -= reduceAmount;
            flashWithoutSound();
        }
    }

    public void onVictory() {
        flash();
        AbstractPlayer p = AbstractDungeon.player;
        if (p.currentHealth <= 0) {return;}
        if (amount > 0) {
            p.heal(this.amount);
        } else if (amount < 0) {
            p.damage(new DamageInfo(this.owner, -this.amount, DamageInfo.DamageType.HP_LOSS));
        }
    }

    @Override
    public int getHealthBarAmount() {
        int healthbar = 0;

        if (amount < 0) {healthbar = amount;}
        //TODO: positive vitality -> green healthbar going forwards
        return healthbar;
    }

    @Override
    public Color getColor() {
        if (amount < 0) {
            return Color.BLACK.cpy();
        } else {
            return Color.GREEN.cpy();
        }
    }

    //TODO: override updatedescription
}
