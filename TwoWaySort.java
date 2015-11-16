public class TwoWaySort {

    static int[] eosort(int[] t) {

        int i, ei, oi, l = t.length;

        for (i=ei=0; i < l; i++)
            if (t[i] % 2 == 0) ei++;

        int[] r = new int[l],
              e = new int[ei],
              o = new int[l-ei];

        for (i=ei=oi=0; i < l; i++) {
            if (t[i] % 2 == 0) e[ei++] = t[i];
            else o[oi++] = t[i];
        }

        java.util.Arrays.sort(e);
        java.util.Arrays.sort(o);
        for(i = 0, oi=o.length; i < oi/2; i++) {
            int s = o[i];
            o[i] = o[oi-i-1];
            o[oi-i-1] = s;
        }

        for (i=ei=oi=0; i < l; i++)
            r[i] = t[i] % 2 == 0 ? e[ei++] : o[oi++];

        return r;

    }

    static void printInts(int[] t) {
        for (int i = 0; i < t.length; i++)
            System.out.print(t[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] t = {0,1,2,3,4,5,6,7,8,9};

        printInts(t);

        printInts(eosort(t));

    }

}
