import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    static int count = 0;
    static int ok = 0;
    static char[] dnaArr;
    static int[] condition = new int[4];
    static int[] checkArr = new int[4];

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dnaL = Integer.parseInt(st.nextToken());
        int extractL = Integer.parseInt(st.nextToken());

        dnaArr = new char[dnaL];
        dnaArr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
          {
            condition[i] = Integer.parseInt(st.nextToken());
            ok = condition[i] == 0 ? ok+1 : ok;
          }

        for (int i = 0; i < extractL; i++)
          {
            doCheck(i);
          }

        count = ok == 4 ? count + 1 : count;

        for (int i = extractL; i < dnaL; i++)
          {
            doCheck(i);
            doMove(i-extractL);
            count = ok == 4 ? count + 1 : count;

          }

        System.out.println(count);
      }

    static void doCheck(int i)
      {
        switch (dnaArr[i])
          {
            case 'A':
              checkArr[0]++;
              ok = checkArr[0] == condition[0] ? ok+1 : ok;
              break;
            case 'C':
              checkArr[1]++;
              ok = checkArr[1] == condition[1] ? ok+1 : ok;
              break;
            case 'G':
              checkArr[2]++;
              ok = checkArr[2] == condition[2] ? ok+1 : ok;
              break;
            case 'T':
              checkArr[3]++;
              ok = checkArr[3] == condition[3] ? ok+1 : ok;
              break;
          }
      }
    static void doMove(int i)
      {
        switch (dnaArr[i])
          {
            case 'A':
              ok = checkArr[0] == condition[0] ? ok-1 : ok;
              checkArr[0]--;
              break;
            case 'C':
              ok = checkArr[1] == condition[1] ? ok-1 : ok;
              checkArr[1]--;
              break;
            case 'G':
              ok = checkArr[2] == condition[2] ? ok-1 : ok;
              checkArr[2]--;
              break;
            case 'T':
              ok = checkArr[3] == condition[3] ? ok-1 : ok;
              checkArr[3]--;
              break;
          }
      }
  }
