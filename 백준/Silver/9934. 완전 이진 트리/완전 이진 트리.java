import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main
  {
    static int k;
    static int n;
    static int[] arr;
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        n = (int) Math.pow(2, k) - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++)
          {
            arr[i] = Integer.parseInt(st.nextToken());
          }

        list = new ArrayList<>();

        for (int i = 0; i < k; i++)
          {
            list.add(new ArrayList<>());
          }

        DFS(0, arr.length - 1, 0);


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++)
          {
            for (int j : list.get(i))
              {
                sb.append(j).append(" ");
              }
            sb.append("\n");
          }

        System.out.println(sb);
      }

    static void DFS(int s, int e, int d)
      {
        if (d == k) return;

        int m = (s + e) / 2;
        list.get(d).add(arr[m]);

        DFS(s, m - 1, d + 1);
        DFS(m + 1, e, d + 1);
      }
  }