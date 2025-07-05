import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubApi {
    public static void main(String[] args) throws Exception {
        // BAD: Hardcoded GitHub personal access token
        String token = "ghp_1A$5435342b3C4d5E6f7G8h9I0jKlMnOpQrStUvWxYz";
        URL url = new URL("https://api.github.com/user/repos");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "token " + token);

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}
