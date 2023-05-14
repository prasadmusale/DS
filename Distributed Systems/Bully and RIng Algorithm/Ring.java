import java.util.Scanner;

public class Ring {
    public static void main(String[] args) {
        int temp, i, j;
        char str[] = new char[10];
        Rr proc[] = new Rr[10];

        // Object initialization
        for (i = 0; i < proc.length; i++)
            proc[i] = new Rr();

        // Scanner used for getting input from console
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int num = in.nextInt();

        // Getting input from users
        for (i = 0; i < num; i++) {
            proc[i].index = 1;
            System.out.println("Enter the id of process: ");
            proc[i].id = in.nextInt();
            proc[i].state = "active";
            proc[i].f = 9;
        }

        // Sorting the processes based on id
        for (i = 0; i < num - 1; i++) {
            for (j = 0; j < num - 1; j++) {
                if (proc[j].id > proc[j + 1].id) {
                    temp = proc[j].id;
                    proc[j].id = proc[j + 1].id;
                    proc[j + 1].id = temp;
                }
            }
        }

        // Find the coordinator
        int coordinator = proc[num - 1].id; // Assuming the last process has the highest ID
        System.out.println("The coordinator is Process " + coordinator);
    }
}

class Rr {
    int index;
    int id;
    String state;
    int f;
}
