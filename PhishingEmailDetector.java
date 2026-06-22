import java.util.Scanner;

public class PhishingEmailDetector {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Email Content:");
        String email = sc.nextLine().toLowerCase();

        int score = 0;

        String[] phishingKeywords = {
            "urgent",
            "verify",
            "password",
            "click here",
            "login",
            "bank",
            "winner",
            "free",
            "account suspended"
        };

        for (String keyword : phishingKeywords) {
            if (email.contains(keyword)) {
                score++;
            }
        }

        if (email.contains("http://") || email.contains("https://")) {
            score++;
        }

        System.out.println("\n----- Result -----");

        if (score >= 3) {
            System.out.println("Classification: PHISHING EMAIL");
        } else {
            System.out.println("Classification: SAFE EMAIL");
        }

        System.out.println("Phishing Score: " + score);

        sc.close();
    }
}