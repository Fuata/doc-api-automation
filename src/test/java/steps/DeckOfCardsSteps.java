package steps;

import api.DeckOfCardsAPI;
import org.testng.Assert;
import response_objects.Deck;

public class DeckOfCardsSteps {

    private Deck deck;
    private String deckID;
    private DeckOfCardsAPI deckOfCardsAPI = new DeckOfCardsAPI();

    public void createNewDeck() {
        deck = deckOfCardsAPI.getNewDeck();
        deckID = deck.getDeck_id();
    }

    public void drawCards(int numberOfCards) {
        deckOfCardsAPI.drawCards(deckID, numberOfCards);
    }

    public void verifyRemaining(int totalCardsDrawn) {
        deck = deckOfCardsAPI.getDeckByID(deck.getDeck_id());
        Assert.assertEquals(52 - totalCardsDrawn, deck.getRemaining());
    }

    public void createNewDeckAndDrawCardsInSameRequest(int numberOfCards) {
        deck = deckOfCardsAPI.drawCards("new", numberOfCards);
        deckID = deck.getDeck_id();
    }

}
