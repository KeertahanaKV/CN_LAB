import java.util.Scanner;

public class TokenBucket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter bucket capacity: ");
        int bucketCapacity = in.nextInt();

        System.out.print("Enter token generation rate: ");
        int tokenGenRate = in.nextInt();

        System.out.print("Enter number of requests: ");
        int n = in.nextInt();

        int[] requests = new int[n];
        System.out.println("Enter token requests:");
        for (int i = 0; i < n; i++) {
            requests[i] = in.nextInt();
        }

        int tokens = 0; // Initially, the bucket is empty
        System.out.println("\nTime\tRequested\tSent\tRemaining");

        for (int i = 0; i < n; i++) {
            // Add new tokens, ensuring we don't exceed bucket capacity
            tokens = Math.min(tokens + tokenGenRate, bucketCapacity);

            // Process the request (allowing partial fulfillment)
            int sent = Math.min(requests[i], tokens);
            tokens -= sent; // Deduct the used tokens

            System.out.printf("%d\t%d\t\t%d\t%d\n", i + 1, requests[i], sent, tokens);
        }

        in.close();
    }
}
