package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomerIO {

    public static List<Customer> readRecords() {
        String fileName = "D://tmp//customers.csv";
        List<String> lines = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            lines = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(System.out::println);

        lines.remove(0);

        Scanner scanner = null;
        for(String line : lines) {
            scanner = new Scanner(line);
            Customer customer = new Customer();

            scanner.useDelimiter(",");
            customer.setId(scanner.next());
            customer.setFirstName(scanner.next());
            customer.setLastName(scanner.next());

            customers.add(customer);
        }

        return customers;

    }

    public static void main(String[] args) {
        readRecords();
    }
}
