import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        char[] c = n.toCharArray();

        for (int i = 0; i < n.length(); i++)
          {
            int index = 0;
            char min = c[i];
            for (int j = i; j < n.length(); j++)
              {
                if (j != n.length() - 1)
                  {
                    if (min > c[j + 1])
                      {
                        min = c[j + 1];
                        index = j + 1;
                      }
                  }
              }
            if (index != 0)
              {
                c[index] = c[i];
                c[i] = min;
              }
          }

        StringBuilder sorted = new StringBuilder();

        for (int i = n.length() - 1; i >= 0; i--)
          {
            sorted.append(c[i]);
          }

        System.out.println(sorted);
        br.close();
      }
  }