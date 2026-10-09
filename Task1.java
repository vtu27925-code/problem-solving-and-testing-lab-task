import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> salaries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            salaries.add(sc.nextInt());
        }

        Function<Integer, Integer> increaseSalary = salary -> (int) (salary * 1.10);

        List<Integer> updatedSalaries = salaries.stream()
                .map(increaseSalary)
                .collect(Collectors.toList());

        updatedSalaries.forEach(salary -> System.out.print(salary + " "));
    }
}
