import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q1 = new PriorityQueue<>((o1, o2) ->
          {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs)
              {
                return o1 > o2 ? 1 : -1;
              }
            return first_abs - second_abs;
          });

        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= n; i++)
          {
            int input = Integer.parseInt(br.readLine());
            if (input == 0)
              {
                if (q1.size() == 0)
                  {
                    sb.append("0\n");
                  }else
                  {
                    sb.append(q1.poll()+"\n");
                  }
              }else
              {
                q1.offer(input);
              }
          }
        br.close();
        System.out.println(sb);
      }
  }