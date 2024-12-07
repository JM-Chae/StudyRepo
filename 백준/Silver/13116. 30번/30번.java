import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());

            int temp = low;
            low = Math.min(high, low);
            if (low == high) high = temp;

            while (true)
              {
                if (high == low)
                  {
                    break;
                  } else if (high < low)
                  {
                    low = low / 2;
                  } else
                  {
                    high = high / 2;
                  }
              }

            System.out.println(high * 10);
          }
      }
  }