package org.example;

public class secretsDemo {
    public static void main(String[] args) {
        // 🔑 AWS Keys (classic example)
        String awsAccessKeyId = "AKIAIOSFODNN7EXAMPLE";
        String awsSecretKey = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";

        // 🔑 Generic API key
        String stripeApiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";

        // 🔐 Passwords in code
        String dbPassword = "superSecret123!";
        String userPassword = "P@ssw0rd123";
        String userPassword2 = "P@ssw0rd123";
        String userPassword3 = "P@ssw0rd123";
        // 🪪 Basic auth
        String authHeader = "Authorization: Basic YWRtaW46YWRtaW4=";

        // 🔐 Private RSA key
        String privateKey = "-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASC...\n-----END PRIVATE KEY-----";




        // 🧬 GitHub token
        String githubToken = "ghp_1234567890abcdefghijklmnopqrstuvwx";
        // ❌ Embedded credentials in URL
        String mongoUrl = "mongodb://admin:password123@localhost:27017";
        // 🔑 JWT Secret
        String jwtSecret = "mySuperJwtSecretKeyThatIsVeryLong";

        System.out.println("Do not use these secrets in production!");
    }
}
