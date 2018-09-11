import api.DeckOfCardsAPI;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.DeckOfCardsSteps;

public class DrawCardsFromDeckTest {

    private DeckOfCardsSteps deckOfCardsSteps;

    @BeforeClass
    public void setupForDrawCardsFromDeckTest() {
        deckOfCardsSteps = new DeckOfCardsSteps();
    }

    @Test(description = "Create new deck, draw cards and verify the remaining cards is as expected")
    public void createNewDeckAndDrawCards() {
        deckOfCardsSteps.createNewDeck();
        int cardsDrawn = 0;
        for(int i = 1; i <= 5; i++) {
            deckOfCardsSteps.drawCards(i);
            cardsDrawn += i;
        }
        deckOfCardsSteps.verifyRemaining(cardsDrawn);
    }

    @Test(description = "Create new deck and draw cards in the same API call, and verify the remaining cards is as expected")
    public void createNewDeckAndDrawCardsInSameAPIRequest() {
        int cardsDrawn = 1;
        deckOfCardsSteps.createNewDeckAndDrawCardsInSameRequest(cardsDrawn);
        for(int i = 2; i <= 5; i++) {
            deckOfCardsSteps.drawCards(i);
            cardsDrawn += i;
        }
        deckOfCardsSteps.verifyRemaining(cardsDrawn);
    }

}
