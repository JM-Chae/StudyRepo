import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main
  {
    static ArrayList<ArrayList<Integer>> home;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();

        for (int i = 0; i <= n; i++)
          {
            home.add(new ArrayList<>());
          }

        for (int i = 1; i <= q; i++)
          {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            DFS(a);
          }
      }

    static void DFS(int n)
      {
        int p = n;
        int firstDuck = 0;
        boolean flag = false;

        while (p > 1)
          {
            if (!home.get(p).isEmpty())
              {
                flag = true;
                firstDuck = home.get(p).get(0);
              }
            p = p / 2;
          }

        if (!flag)
          {
            home.get(n).add(n);
            System.out.println(0);
          } else
          {
            System.out.println(firstDuck);
          }
      }
  }