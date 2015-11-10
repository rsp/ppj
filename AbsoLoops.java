public class AbsoLoops {

    // https://github.com/rsp/ppj

    public static void main(String[] args) {

        int m = 5;

        for (int j = -m; j <= m; j++) {
            for (int i = 0; i-m <= Math.abs(j); i++)
                System.out.print(m-i > Math.abs(j) ? " " : "*");
            System.out.println();
        }

    }

}
