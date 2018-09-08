import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import response_objects.Deck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeckOfCardsAPI {

    private String baseURI = "https://deckofcardsapi.com/api/deck";
    private RequestSpecification request;

    public Deck getNewDeck() {
        RestAssured.baseURI = baseURI;
        request = RestAssured.given();

        Response response = request.get(APIEndpoints.NEW_DECK.getURL());

        Gson g = new Gson();
        return g.fromJson(response.asString(), Deck.class);

    }

    public Deck drawCards(String deckID, int count) {

        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("<<deck_id>>", deckID);
        String url = APIHelper.formulateURL(APIEndpoints.DRAW_A_CARD.getURL(), urlParams);

        RestAssured.baseURI = baseURI;
        Map<String, Object> qParams = new HashMap<String, Object>();
        qParams.put("count", count);
        request = RestAssured.given().queryParams(qParams);

        Response response = request.get(url);

        Gson g = new Gson();
        return g.fromJson(response.asString(), Deck.class);

    }

}