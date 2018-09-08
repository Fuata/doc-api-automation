import java.util.HashMap;
import java.util.Map;

public class APIHelper {

    public static String formulateURL(String initialUrl, Map<String, String> urlParams) {

        String finalUrl = initialUrl;

        for(Map.Entry<String, String> entry : urlParams.entrySet()) {
            finalUrl = finalUrl.replace(entry.getKey(), entry.getValue());
        }

        return finalUrl;
    }

}
