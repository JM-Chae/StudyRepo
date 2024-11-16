import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        a:
        while (true)
          {
            String tc = br.readLine();

            if (tc.equals(".")) break;
            Stack<Character> st = new Stack<>();

            for (int i = 0; i < tc.length(); i++)
              {
                if (tc.charAt(i) == '[' || tc.charAt(i) == '(')
                  {
                    st.push(tc.charAt(i));
                  } else if (tc.charAt(i) == ']')
                  {
                    if (st.isEmpty())
                      {
                        sb.append("no\n");
                        continue a;
                      } else if (st.pop() == '[')
                      {
                        continue;
                      } else
                      {
                        sb.append("no\n");
                        continue a;
                      }
                  } else if (tc.charAt(i) == ')')
                  {
                    if (st.isEmpty())
                      {
                        sb.append("no\n");
                        continue a;
                      } else if (st.pop() == '(')
                      {
                        continue;
                      } else
                      {
                        sb.append("no\n");
                        continue a;
                      }
                  }

                if (i == tc.length() - 1 && st.isEmpty())
                  {
                    sb.append("yes\n");
                  } else if (i == tc.length() - 1)
                  {
                    sb.append("no\n");
                  }
              }
          }

        System.out.println(sb);
        br.close();
      }
  }