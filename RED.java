import java.util.Scanner;

public class CN9 {
    public static void main(String args[]) {
        // Create Scanner object to take input from user
        Scanner in = new Scanner(System.in);

        // User inputs for maximum number of packets and queue size
        System.out.println("Enter the maximum number of packets:");
        int maxPac = in.nextInt();  // Maximum number of packets

        System.out.println("Enter the queue size:");
        int queSize = in.nextInt();  // Queue size (max capacity)

        // User inputs for minimum and maximum drop probabilities
        System.out.println("Enter the minimum drop probability:");
        double minPro = in.nextDouble();  // Minimum drop probability

        System.out.println("Enter the maximum drop probability:");
        double maxPro = in.nextDouble();  // Maximum drop probability

        // User input for the minimum and maximum threshold
        System.out.println("Enter the minimum threshold (0 to " + queSize + "):");
        int minTh = in.nextInt();  // Minimum threshold

        System.out.println("Enter the maximum threshold (0 to " + queSize + "):");
        int maxTh = in.nextInt();  // Maximum threshold

        // Initial values for queue length and drop probability
        int queLen = 0;  // Current length of the queue
        double dropPro = minPro;  // Initial drop probability

        // Process the packets
        for (int i = 0; i < maxPac; ++i) {
            // Check if the queue is full
            if (queLen == queSize) {
                System.out.println("Packet dropped (Queue Full)");
                dropPro = minPro;  // Reset drop probability when the queue is full
            } else {
                // If the queue length is below the minimum threshold, no packet is dropped
                if (queLen < minTh) {
                    System.out.println("Packet Accepted");
                    queLen++;  // Accept the packet, increment queue length
                    dropPro = minPro;  // Reset drop probability when packet is accepted
                }
                // If the queue length is between the minimum and maximum threshold, drop probability increases linearly
                else if (queLen >= minTh && queLen <= maxTh) {
                    // Linearly increase drop probability
                    dropPro = minPro + (maxPro - minPro) * ((double)(queLen - minTh) / (maxTh - minTh));

                    // Random drop decision based on the current drop probability
                    if (Math.random() < dropPro) {
                        System.out.println("Packet dropped (Random)");
                    } else {
                        System.out.println("Packet Accepted");
                        queLen++;  // Accept the packet, increment queue length
                    }
                }
                // If the queue length is above the maximum threshold, drop packets with high probability
                else if (queLen > maxTh) {
                    dropPro = maxPro;  // Set drop probability to maxPro
                    System.out.println("Packet dropped (High Drop Probability)");
                }
            }

            // Output the current queue length and drop probability
            System.out.println("Current queue length: " + queLen);
            System.out.println("Current drop probability: " + dropPro);

            // If the queue length exceeds the maximum capacity, don't add more packets
            if (queLen >= queSize) {
                queLen = queSize;  // Cap the queue length to the max size
            }
        }

        in.close();  // Close the scanner
    }
}
