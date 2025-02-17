package erp;

import erp.domains.Services.CommandParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class ConsoleApp {
    private final CommandParser commandParser;

    @Autowired
    public ConsoleApp(CommandParser commandParser) {
        this.commandParser = commandParser;
    }

    /**
     * Метод, который запускает приложение и обрабатывает запросы пользователя.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Moscow Zoo ERP");
        System.out.println("Enter any of available commands");

        while (true) {
            System.out.print("> ");
            var input = scanner.nextLine();
            String result = commandParser.parseCommandLine(input.split(" "));

            if ("exit".equals(result)) {
                break;
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConsoleApp.class, args);
        ConsoleApp app = context.getBean(ConsoleApp.class);
        app.run();
    }
}