package alchemistmod.cards;

public abstract class AbstractHumourCard extends AbstractEasyCard { //TODO: custom description Skill | Humour | etc

    public AbstractHumourCard(final String cardID, final int cost, final CardRarity rarity, final CardTarget target) {
        super(cardID, cost, CardType.SKILL, rarity, target);
        tags.add(CustomTags.HUMOUR);
    }

    @Override
    public void upgrade() {
        this.upgradeName();
        this.upp();
        if (this.cardStrings.UPGRADE_DESCRIPTION != null) {
            this.uDesc();
        }
    }

    @Override
    public boolean canUpgrade() {
        return true;
    }
}