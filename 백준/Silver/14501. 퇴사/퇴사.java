import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    static int[] t;
    static int[] p;
    static int n;
    static int[] maxP;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        t = new int[n];
        p = new int[n];
        maxP = new int[n + 1];

        for (int i = 0; i < n; i++)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
          }

        find();

        System.out.println(maxP[n]);
      }

    static void find()
      {
        for (int i = 0; i < n; i++)
          {
            if (i + t[i] <= n)
              {
                maxP[i + t[i]] = Math.max(maxP[t[i] + i], p[i] + maxP[i]);
              }
            maxP[i + 1] = Math.max(maxP[i + 1], maxP[i]);
          }
      }
  }