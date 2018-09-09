package response_objects;

import java.util.List;

public class Deck {

    boolean success;
    List<Card> cards;
    String deck_id;
    boolean shuffled;
    int remaining;

    public boolean isSuccess() {
        return success;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public int getRemaining() {
        return remaining;
    }
}
