import java.util.Scanner;

public class Bully {
    static boolean state[] = new boolean[5];
    static int coordinator;

    public static void up(int up) {
        if (state[up - 1]) {
            System.out.println("Process " + up + " is already up.");
        } else {
            int i;
            state[up - 1] = true;
            System.out.println("Process " + up + " held an election.");
            for (i = up; i < 5; i++) {
                if (state[i]) {
                    System.out.println("Election message sent from process " + up + " to process " + i);
                    break;
                }
            }
            for (i = up + 1; i <= 5; i++) {
                if (state[i - 1])
                    continue;
                System.out.println("Alive message sent from process " + i + " to process " + up);
                break;
            }
        }
    }

    public static void down(int down) {
        if (!state[down - 1]) {
            System.out.println("Process " + down + " is already down.");
        } else {
            state[down - 1] = false;
            System.out.println("Process " + down + " is down.");
            if (down == coordinator) {
                int newCoordinator = electCoordinator();
                System.out.println("Coordinator process " + coordinator + " is down. New coordinator is process "
                        + newCoordinator);
            }
        }
    }

    public static void mess(int mess) {
        if (state[mess - 1]) {
            if (coordinator == mess) {
                System.out.println("OK");
            } else {
                System.out.println("Process " + mess + " held an election.");
                int newCoordinator = electCoordinator();
                System.out.println("New coordinator is process " + newCoordinator);
            }
        }
    }

    public static int electCoordinator() {
        for (int i = 4; i >= 0; i--) {
            if (state[i])
                return i + 1;
        }
        return -1; // No active process found
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Initialize the states of all processes
        for (int i = 0; i < state.length; i++) {
            state[i] = true; // Assuming all processes are initially up
        }

        // Select initial coordinator
        coordinator = electCoordinator();

        while (true) {
            System.out.println("\n---- Bully Algorithm Menu ----");
            System.out.println("1. Bring a process up");
            System.out.println("2. Bring a process down");
            System.out.println("3. Send a message");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the process number to bring up: ");
                    int up = in.nextInt();
                    up(up);
                    break;
                case 2:
                    System.out.print("Enter the process number to bring down: ");
                    int down = in.nextInt();
                    down(down);
                    break;
                case 3:
                    System.out.print("Enter the process number to send a message: ");
                    int mess = in.nextInt();
                    mess(mess);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
