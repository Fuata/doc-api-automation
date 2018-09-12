package api;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import response_objects.Deck;

import java.util.HashMap;
import java.util.Map;

public class DeckOfCardsAPI {

    private String baseURI = "https://deckofcardsapi.com/api/deck";
    private RequestSpecification request;

    public DeckOfCardsAPI() {
        RestAssured.baseURI = baseURI;
    }

    /**
     * Sends a request to generate a new deck, and returns the response as a Deck object.
     *
     * @return  a new deck as a Deck object
     */
    public Deck getNewDeck() {

        request = RestAssured.given();

        Response response = request.get(APIEndpoints.NEW_DECK.getURL());

        return parseResponseToDeck(response);

    }

    /**
     * Sends a request to draw a number of cards, specified by the count parameter, from the deck whose deckID is
     * provided, and returns the same deck with cards removed (returning the cards drawn in the same response) as a
     * Deck object.
     *
     * NOTE:    You can use this request to create and draw from the deck at the same time, by passing the string "new"
     *          into the method in place of the deckID.
     *          e.g.    the URL of the request will be something similar to
     *                  https://deckofcardsapi.com/api/deck/new/draw/?count=2
     *
     * @param deckID    the ID of the deck to be drawn from (or string "new" to generate a new deck in the same request)
     * @param count     the number of cards to be drawn
     * @return          the deck as a Deck object
     */
    public Deck drawCards(String deckID, int count) {

        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("<<deck_id>>", deckID);
        String url = APIHelper.formulateURL(APIEndpoints.DRAW_A_CARD.getURL(), urlParams);

        Map<String, Object> qParams = new HashMap<String, Object>();
        qParams.put("count", count);
        request = RestAssured.given().queryParams(qParams);

        Response response = request.get(url);

        return parseResponseToDeck(response);

    }

    /**
     * Sends a request to return the deck with the deckID provided as a Deck object
     *
     * @param deckID    the ID of the deck
     * @return          the deck as a Deck object
     */
    public Deck getDeckByID(String deckID) {
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("<<deck_id>>", deckID);
        String url = APIHelper.formulateURL(APIEndpoints.GET_DECK_BY_ID.getURL(), urlParams);

        request = RestAssured.given();

        Response response = request.get(url);

        return parseResponseToDeck(response);
    }

    /**
     * Parses the response as a Deck object, and returns it
     *
     * @param response  the response to be parsed as a Deck object
     * @return          the response as a Deck object
     */
    public Deck parseResponseToDeck(Response response) {
        Gson g = new Gson();
        return g.fromJson(response.asString(), Deck.class);
    }

}