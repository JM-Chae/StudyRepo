import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
          {
            arr[i] = Integer.parseInt(br.readLine());
          }

        StringBuffer bf = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        boolean ok = true;
        int m = 1;

        for (int i = 0; i < arr.length; i++)
          {
            int j = arr[i];

            if (j >= m)
              {
                while (j >= m)
                  {
                    stack.push(m++);
                    bf.append("+\n");
                  }
                stack.pop();
                bf.append("-\n");
              } else
              {
                int h = stack.pop();
                if (h > j)
                  {
                    System.out.println("NO");
                    ok = false;
                    break;
                  } else bf.append("-\n");
              }
          }

        if (ok)
          {
            bf.deleteCharAt(bf.length() - 1);
            System.out.println(bf);
          }
        br.close();
      }
  }