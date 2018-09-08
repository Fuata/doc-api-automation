import java.util.Map;

public enum APIEndpoints {

    // Endpoint URLs
    DRAW_A_CARD("/<<deck_id>>/draw"),
    NEW_DECK("/new");


    // Fields and Methods
    private final String URL;
    APIEndpoints(String url) {
        this.URL = url;
    }
    public String getURL() {
        return this.URL;
    }

}
