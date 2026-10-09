import java.util.*;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : map.keySet())
            System.out.println(s + " " + map.get(s));
    }
}
