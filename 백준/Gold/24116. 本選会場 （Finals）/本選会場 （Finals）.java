import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

    static int n, m, k;
    static ArrayList<Integer[]> map;
    static int[] d;
    static int count;
    static int total_cost;
    static int[] position;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        position = new int[n + 1];
        map = new ArrayList<>();
        d = new int[n + 1];
        count = 0;
        total_cost = 0;

        for (int i = 1; i <= n; i++) {
            position[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map.add(new Integer[]{a, b, c});
        }

        map.sort(Comparator.comparingInt(temp -> temp[2]));

        for (int i = 0; i < m; i++) {
            if (n - count <= k) {
                break;
            }

            union(i);
        }

        System.out.println(total_cost);
    }

    static void union(int a) {
        int cur = map.get(a)[0];
        int next = map.get(a)[1];
        int cost = map.get(a)[2];

        int cur_position = find(cur);
        int next_position = find(next);

        if (cur_position == next_position) {
            return;
        }

        if (d[cur_position] > d[next_position]) {
            position[next_position] = cur_position;
        } else if (d[cur_position] < d[next_position]) {
            position[cur_position] = next_position;
        } else {
            d[cur_position]++;
            position[next_position] = cur_position;
        }

        count++;
        total_cost += cost;
    }

    static int find(int a) {
        return position[a] == a ? a : find(position[a]);
    }
}