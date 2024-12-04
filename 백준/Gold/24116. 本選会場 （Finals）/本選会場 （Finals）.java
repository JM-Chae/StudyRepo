import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main
  {
    static ArrayList<Integer[]> arr = new ArrayList<>();
    static ArrayList<Integer>[] chizu;
    static int cost = 0;
    static int count = 0;
    static int[] depth;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        chizu = new ArrayList[n + 1];
        depth = new int[n + 1];

        for (int i = 1; i <= n; i++)
          {
            chizu[i] = new ArrayList<>();
            chizu[i].add(i);
            depth[i] = 0;
          }

        for (int i = 1; i <= m; i++)
          {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.add(new Integer[]{a, b, c});
          }

        arr.sort(Comparator.comparingInt(temp -> temp[2]));

        for (int i = 0; i < m; i++)
          {
            if (n - count > k) union(i);
          }

        System.out.println(cost);
      }

    static public void union(int i)
      {
        int s = arr.get(i)[0];
        int e = arr.get(i)[1];
        int c = arr.get(i)[2];

        int a = find(s);
        int b = find(e);

        if (a == b) return;

        if (depth[a] < depth[b]) chizu[a].set(0, b);
        else if (depth[a] > depth[b]) chizu[b].set(0, a);
        else
          {
            chizu[a].set(0, b);
            depth[b]++;
          }

        count++;
        cost = cost + c;
      }

    static public int find(int road)
      {
        return chizu[road].get(0) == road ? road : find(chizu[road].get(0));
      }
  }