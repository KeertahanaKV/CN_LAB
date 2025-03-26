import java.util.Scanner;

public class tb {
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

        int tokens = 0;
        System.out.println("\nTime\tRequested\tSent\tRemaining");

        for (int i = 0; i < n; i++) {
            tokens = Math.min(tokens + tokenGenRate, bucketCapacity);
            int sent = (requests[i] <= tokens) ? requests[i] : 0;
            tokens -= sent;

            System.out.printf("%d\t%d\t\t%d\t%d\n", i + 1, requests[i], sent, tokens);
        }
        in.close();
    }
}
