package org.example;
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
        String awsAccessKeyId = "AKIA5NH7L4P3KJ2U9D3N";
        String awsSecretKey = "N7k58Gv+WbqUVsRiZcKZpu7FmAIfs8WlYuU5U9XL";
        // 🔐 GitHub Token


        String githubToken = "ghp_D8fR2sY9ABQpGgW2S3xF4dVYZkNpWqz57TbR";
        String githubToken44 = "ghp_D8fR2sY9ABQpGgW2S3xF4dVYZkNpWqz57TbR";
        // 🔐 GitLab Token
        String gitlabToken = "glpat-28eFqsNLmXKJxuPbaYBZ";
        String gitlabToken2 = "glpat-28eFqsNLmXKJxuPbaYBZ";
        // 🔐 Slack Bot Token
        String slackBotToken = "xoxb-875392083274-987654321098-zD47HhU0LvIUGY6oDsP7hVJf";
        // 🔐 Twilio Auth Token
    }





}
