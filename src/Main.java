import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();

        UserInterface ui = new UserInterface(scanner, taskList);

        ui.start();
    }
}
