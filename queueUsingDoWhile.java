import java.util.Scanner;
class TicketCounter {
    private String[] line;
    private int front = 0, rear = -1, count = 0;

    TicketCounter(int size) {
        line = new String[size];
    }

    void join(String name) {
        if (count == line.length) {
            System.out.println("Line full! " + name + " please wait outside.");
            return;
        }
        rear = (rear + 1) % line.length;
        line[rear] = name;
        count++;
        System.out.println(name + " joined the line.");
    }

    void serve() {
        if (count == 0) {
            System.out.println("No one in line.");
            return;
        }
        System.out.println("Ticket given to: " + line[front]);
        line[front] = null;
        front = (front + 1) % line.length;
        count--;
    }

    void showLine() {
        if (count == 0) {
            System.out.println("Line is empty.");
            return;
        }
        System.out.print("Line: ");
        for (int i = 0; i < count; i++) {
            System.out.print(line[(front + i) % line.length] + " ");
        }
        System.out.println();
    }
}

public class queueUsingDoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter line capacity: ");
        int size = sc.nextInt();
        sc.nextLine();

        TicketCounter t = new TicketCounter(size);
        int choice;

        do {
            System.out.println("\n=== QUEUE: Ticket Counter ===");
            System.out.println("1. Join line");
            System.out.println("2. Serve ticket");
            System.out.println("3. Show line");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    t.join(sc.nextLine());
                    break;
                case 2:
                    t.serve();
                    break;
                case 3:
                    t.showLine();
                    break;
                case 0:
                    System.out.println("Counter closed. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}