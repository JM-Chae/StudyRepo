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
            if ( i != n.length() -1)
              {
                for (int j = i + 1; j > 0; j--)
                  {
                    if (c[j] < c[j - 1])
                      {
                        char temp = c[j - 1];
                        c[j - 1] = c[j];
                        c[j] = temp;
                      }
                  }
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