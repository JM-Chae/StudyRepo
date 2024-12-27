import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    static int[] pass = new int[4];
    static int[] lock = new int[4];

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int count = 0;

        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        char[] DNAarr = DNA.toCharArray();

        for (int i = 0; i < 4; i++)
          {
            lock[i] = Integer.parseInt(st.nextToken());
          }

        for (int i = 0; i < p; i++)
          {
            checkNext(DNAarr[i]);
          }

        if (ans()) count++;

        for (int i = p; i < s; i++)
          {
            checkPrev(DNAarr[i - p]);
            checkNext(DNAarr[i]);
            if (ans()) count++;
          }

        System.out.println(count);
      }

    static void checkNext(char DNAChar)
      {
        switch (DNAChar)
          {
            case 'A':
              pass[0] += 1;
              break;

            case 'C':
              pass[1] += 1;
              break;

            case 'G':
              pass[2] += 1;
              break;

            case 'T':
              pass[3] += 1;
              break;
          }
      }

    static void checkPrev(char DNAChar)
      {
        switch (DNAChar)
          {
            case 'A':
              pass[0] -= 1;
              break;

            case 'C':
              pass[1] -= 1;
              break;

            case 'G':
              pass[2] -= 1;
              break;

            case 'T':
              pass[3] -= 1;
              break;
          }
      }

    static boolean ans()
      {
        return pass[0] >= lock[0] && pass[1] >= lock[1] && pass[2] >= lock[2] && pass[3] >= lock[3];
      }
  }
