import java.util.Scanner;

public class lb{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter bucket capacity: ");
        int bucketCapacity = in.nextInt();
        System.out.print("Enter output rate: ");
        int outputRate = in.nextInt();
        System.out.print("Enter number of packets: ");
        int n = in.nextInt();
        
        int[] packets = new int[n]; // Packet sizes
        System.out.println("Enter packet sizes:");
        for (int i = 0; i < n; i++) {
            packets[i] = in.nextInt();
        }

        int bucketRemaining = 0;
        System.out.println("\nTime\tPacket\tAccepted\tSent\tRemaining");

        for (int i = 0; i < n; i++) {
            int received = (bucketRemaining + packets[i] > bucketCapacity) ? -1 : packets[i];

            if (received != -1) bucketRemaining += packets[i];

            int sent = Math.min(bucketRemaining, outputRate);
            bucketRemaining -= sent;
 
            System.out.printf("%d\t%d\t%s\t\t%d\t%d\n", i + 1, packets[i], (received == -1 ? "Dropped" : received), sent, bucketRemaining);
        }
        in.close();
    }
}
