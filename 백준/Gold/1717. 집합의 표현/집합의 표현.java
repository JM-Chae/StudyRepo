import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
  {
    static int[] a;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new int[n + 1];

        for (int i = 0; i <= n; i++)
          {
            a[i] = i;
          }

        for (int i = 0; i < m; i++)
          {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            app(j, k, l);
          }
      }

    static void app(int j, int k, int l)
      {
        if (j == 0)
        {
          union(k, l);
        } else
        {
          int b = find(k);
          int c = find(l);

          if(b == c)
            {
              System.out.println("YES");
            }else
            {
              System.out.println("NO");
            }
        }
      }

    static void union(int k, int l)
      {
        int b = find(k);
        int c = find(l);

        a[c] = b;
      }

    static int find(int i)
      {
        if (a[i] == i)
          {
            return i;
          } else
          {
            return a[i] =  find(a[i]);
          }
      }
  }