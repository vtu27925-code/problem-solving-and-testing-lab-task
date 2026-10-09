import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : g.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        System.out.println(visited[dest] ? "YES" : "NO");
    }
}
