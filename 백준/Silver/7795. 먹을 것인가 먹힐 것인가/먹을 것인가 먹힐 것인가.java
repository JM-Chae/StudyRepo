import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        long Q = 0L;
        while (Q < T)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());
            long count = 0L;
            long[] arrN = new long[(int) N];
            long[] arrM = new long[(int) M];
            long index = 0L;

            long pntN = N - 1L;
            long pntM = 0L;

            st = new StringTokenizer(br.readLine());
            for (long i = 0; i < N; i++)
              {
                arrN[(int) i] = Long.parseLong(st.nextToken());
              }

            st = new StringTokenizer(br.readLine());
            for (long i = 0; i < M; i++)
              {
                arrM[(int) i] = Long.parseLong(st.nextToken());
              }

            Arrays.sort(arrN);
            Arrays.sort(arrM);

            while (index < N)
              {
                if (pntM < M)
                  {
                    if (arrN[(int) pntN] > arrM[(int) pntM])
                      {
                        count++;
                        pntM++;
                      } else
                      {
                        pntN--;
                        index++;
                        pntM = 0L;
                      }
                  } else
                  {
                    pntN--;
                    index++;
                    pntM = 0L;
                  }
              }

            System.out.println(count);
            Q++;
          }
      }
  }