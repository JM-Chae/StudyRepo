import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int size = Math.max(a, b);

            int[] list = new int[size + 1];

            for (int j = 0; j <= size; j++)
              {
                list[j] = j;
              }

            HashSet<Integer> temp = new HashSet<>();
            int ans = 1;

            for (int j = a; j > 1; j = j / 2)
              {
                temp.add(list[j]);
              }
            for (int j = b; j > 1; j = j / 2)
              {
                if (temp.contains(list[j]))
                  {
                    ans = Math.max(ans, list[j]);
                  }
              }

            System.out.println(ans * 10);
          }
      }
  }