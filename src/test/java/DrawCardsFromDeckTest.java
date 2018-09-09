import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import response_objects.Deck;

public class DrawCardsFromDeckTest {

    DeckOfCardsAPI deckOfCardsAPI;

    @BeforeClass
    public void setupForDrawCardsFromDeckTest() {
        deckOfCardsAPI = new DeckOfCardsAPI();
        deckOfCardsAPI.setBaseURI();
    }

    @Test
    public void createNewDeckAndDrawCards() {
        Deck deck = deckOfCardsAPI.getNewDeck();
        String deckID = deck.getDeck_id();
        int cardsDrawn = 0;
        for(int i = 1; i <= 5; i++) {
            deckOfCardsAPI.drawCards(deckID, i);
            cardsDrawn += i;
        }

        deck = deckOfCardsAPI.getDeckByID(deck.getDeck_id());
        Assert.assertEquals(52 - cardsDrawn, deck.getRemaining());
    }

    @Test
    public void createNewDeckAndDrawCardsInSameAPIRequest() {
        int cardsDrawn = 0;
        Deck deck = deckOfCardsAPI.drawCards("new", 1);
        String deckID = deck.getDeck_id();
        cardsDrawn++;

        for(int i = 2; i <= 5; i++) {
            deckOfCardsAPI.drawCards(deckID, i);
            cardsDrawn += i;
        }

        deck = deckOfCardsAPI.getDeckByID(deck.getDeck_id());
        Assert.assertEquals(52 - cardsDrawn, deck.getRemaining());
    }

}
