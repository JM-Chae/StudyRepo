import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();

        StringBuffer sb = new StringBuffer();
        StringBuilder reverse = new StringBuilder();

        for (int i = 0; i < s.length; i++)
          {
            char c = s[i];
            if (c == '<')
              {
                if (reverse.length() > 0)
                  {
                    sb.append(reverse.reverse());
                    reverse.delete(0, reverse.length());
                  }
                while (c != '>')
                  {
                    sb.append(s[i]);
                    c = s[++i];
                  }
                sb.append(s[i]);
              } else if (c == ' ')
              {
                for (int j = reverse.length() - 1; j >= 0; j--)
                  {
                    sb.append(reverse.charAt(j));
                  }
                sb.append(' ');
                reverse.delete(0, reverse.length());
              } else
              {
                reverse.append(c);
              }
          }
        if (reverse.length() > 0)
          {
            for (int j = reverse.length() - 1; j >= 0; j--)
              sb.append(reverse.charAt(j));
            reverse.delete(0, reverse.length());
          }
        System.out.println(sb);
        br.close();
      }
  }