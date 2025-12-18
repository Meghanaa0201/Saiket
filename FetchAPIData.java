// Task 2: Fetch Data from API
// Saiket Systems Internship
// Student Project

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FetchAPIData {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   API DATA FETCHER");
        System.out.println("   Saiket Systems Internship");
        System.out.println("========================================\n");
        
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Fetch Random Joke");
            System.out.println("2. Fetch Random Quote");
            System.out.println("3. Fetch Random User");
            System.out.println("4. Exit");
            System.out.print("\nEnter choice (1-4): ");
            
            String ch = sc.nextLine();
            
            switch (ch) {
                case "1":
                    getJoke();
                    break;
                case "2":
                    getQuote();
                    break;
                case "3":
                    getUser();
                    break;
                case "4":
                    System.out.println("\nThank you!");
                    System.out.println("#SaiKetInnovation #SaiKetAchievements");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid!\n");
            }
        }
    }
    
    // get joke
    public static void getJoke() {
        try {
            String url = "https://official-joke-api.appspot.com/random_joke";
            String data = fetchData(url);
            
            System.out.println("\n========================================");
            System.out.println("         RANDOM JOKE");
            System.out.println("========================================");
            
            String setup = getValue(data, "setup");
            String punch = getValue(data, "punchline");
            
            System.out.println(setup);
            System.out.println(punch);
            System.out.println("========================================\n");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
    
    // get quote
    public static void getQuote() {
        try {
            String url = "https://api.quotable.io/random";
            String data = fetchData(url);
            
            System.out.println("\n========================================");
            System.out.println("         RANDOM QUOTE");
            System.out.println("========================================");
            
            String text = getValue(data, "content");
            String author = getValue(data, "author");
            
            System.out.println("\"" + text + "\"");
            System.out.println("\n- " + author);
            System.out.println("========================================\n");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
    
    // get user
    public static void getUser() {
        try {
            String url = "https://randomuser.me/api/";
            String data = fetchData(url);
            
            System.out.println("\n========================================");
            System.out.println("         RANDOM USER PROFILE");
            System.out.println("========================================");
            
            String first = getNestedValue(data, "name", "first");
            String last = getNestedValue(data, "name", "last");
            String email = getValue(data, "email");
            String phone = getValue(data, "phone");
            
            System.out.println("Name:  " + first + " " + last);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("========================================\n");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
    
    // fetch from api
    public static String fetchData(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conn.getInputStream()));
        
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line);
        }
        in.close();
        
        return result.toString();
    }
    
    // get json value
    public static String getValue(String json, String key) {
        try {
            String search = "\"" + key + "\":\"";
            int start = json.indexOf(search) + search.length();
            int end = json.indexOf("\"", start);
            return json.substring(start, end);
        } catch (Exception e) {
            return "N/A";
        }
    }
    
    // get nested value
    public static String getNestedValue(String json, String parent, String child) {
        try {
            String search = "\"" + parent + "\":{";
            int idx = json.indexOf(search);
            String sub = json.substring(idx);
            return getValue(sub, child);
        } catch (Exception e) {
            return "N/A";
        }
    }
}
