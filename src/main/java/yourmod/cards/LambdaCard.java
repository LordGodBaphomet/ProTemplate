package yourmod.cards;

public abstract class LambdaCard extends AbstractReptoCard {
    public LambdaCard(final String cardID, final int cost, final CardType type, final CardRarity rarity, final CardTarget target) {
        super(cardID, cost, type, rarity, target);
    }

    public LambdaCard(final String cardID, final int cost, final CardType type, final CardRarity rarity, final CardTarget target, final CardColor color) {
        super(cardID, cost, type, rarity, target, color);
    }
}
