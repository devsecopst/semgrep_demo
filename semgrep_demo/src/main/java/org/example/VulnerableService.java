package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableService {

    private static final Logger logger = LogManager.getLogger(VulnerableService.class);

    // Hardcoded secret - example of secret scanning
    private static final String API_KEY = "sk_test_1234567456789)(*^&*jghjhfgjhgkhljsfdxcvb890abcdef";
    private static final String API_KEY2 = "sk_test_1234567456789)(*^&*jghjhfgjhgkhljsfdxcvb890abcdef";
    private static final String API_KEY3 = "sk_test_1234567456789)(*^&*jghjhfgjhgkhljsfdxcvb890abcdef";
    private static final String API_KEY4 = "sk_test_1234567456789)(*^&*jghjhfgjhgkhljsfdxcvb890abcdef";


    public void vulnerableSqlQuery(String userInput) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            Statement stmt = conn.createStatement();

            // Vulnerable to SQL Injection - user input concatenated directly
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }



            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void printApiKey() {
        System.out.println("API Key: " + API_KEY);
        String azureStorageKey = "qPFPcOKhZ0gF93nRfZf5krVXvFXKpNGCu/mUZnMY4QnR+aKBLzsyCA==";

    }





    // Insecure Jackson deserialization - polymorphic deserialization enabled without filtering
    public void jacksonDeserialize(String jsonPayload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // No typing restrictions, dangerous in older versions
            Object obj = mapper.readValue(jsonPayload, Object.class);
            System.out.println("Deserialized object: " + obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insecure Log4j usage with user-controlled input leading to JNDI injection
    public void log4jJndiInjection(String userInput) {
        // This logs user input without sanitization — vulnerable to Log4Shell
        logger.info("User input: " + userInput);
    }
}
