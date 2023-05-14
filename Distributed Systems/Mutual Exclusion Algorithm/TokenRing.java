import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TokenRing {
    public static void main(String args[]) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of nodes: ");
        int n = Integer.parseInt(br.readLine());

        int token = 0;
        int ch = 1;

        for (int i = 0; i < n; i++) {
            System.out.print("Node " + (i + 1) + ": ");
            System.out.println("- 0");
        }

        try {
            while (ch == 1) {
                System.out.println("Enter sender:");
                int sender = Integer.parseInt(br.readLine());

                System.out.println("Enter receiver:");
                int receiver = Integer.parseInt(br.readLine());

                System.out.println("Enter Data:");
                String data = br.readLine();

                System.out.print("Token passing: ");
                for (int i = sender; i <= receiver; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();

                System.out.println("Sender " + sender + " sending data: " + data);
                for (int i = sender + 1; i <= receiver; i++) {
                    System.out.println("Data forwarded by " + i);
                }

                System.out.println("Receiver " + receiver + " received data: " + data);

                token = receiver + 1;
                if (token > n) {
                    token = 1;
                }

                System.out.println("Token - " + token);

                System.out.println("Continue? (1/0)");
                ch = Integer.parseInt(br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
