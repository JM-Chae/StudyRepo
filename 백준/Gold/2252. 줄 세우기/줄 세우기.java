import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
  {
    static ArrayList<Integer>[] arr;
    static int[] line;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        line = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
          {
            arr[i] = new ArrayList<>();
            line[i] = 0;
          }

        for (int i = 0; i < m; i++)
          {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
          }

        for (int i = 1; i <= n; i++)
          {
            for (int j = 0; j < arr[i].size(); j++)
              {
                int temp = arr[i].get(j);
                line[temp] += 1;
              }
          }

        for (int i = 1; i <= n; i++)
          {
            sort(i);
          }

        System.out.println(sb);
      }

    static void sort(int i)
      {
        if (!visited[i])
          {

            if (line[i] == 0)
              {
                visited[i] = true;
                sb.append(i).append(" ");
                for (int j = 0; j < arr[i].size(); j++)
                  {
                    int temp = arr[i].get(j);
                    line[temp] -= 1;
                    if (line[temp] == 0)
                      {
                        sort(temp);
                      }
                  }
              }
          }
      }
  }