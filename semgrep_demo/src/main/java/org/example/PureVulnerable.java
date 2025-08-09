package org.example;
import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class PureVulnerable {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // 🔥 1. Insecure Randomness
        Random random = new Random();
        int token = random.nextInt();
        System.out.println("Generated session token: " + token);


        // 🔥 2. Command Injection
        System.out.print("Enter command to run: ");
        String userCommand = scanner.nextLine();
        Process proc = Runtime.getRuntime().exec("sh -c " + userCommand);
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line;
        System.out.println("Command output:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        // 🔥 3. Path Traversal
        System.out.print("Enter filename to read: ");
        String filename = scanner.nextLine();
        File file = new File("/tmp/" + filename); // vulnerable to ../../etc/passwd
        if (file.exists()) {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            System.out.println("File contents:");
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }



        } else {
            System.out.println("File  not found.");
        }


        // 🔥 4. Hardcoded Credentials (optional)
        String username = "admin";
        String password = "supe$$$rsecret123"; // hardcoded password
        System.out.println("Logging in with user: " + username);
        // 🔥 5. Insecure Socket (no TLS)
        System.out.println("Opening plain socket to attacker.com:1337...");
        Socket socket = new Socket("attacker.com", 1337); // not encrypted
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello, attacker!");
        socket.close();
    }
}
