public class LoopArithmetic {

    // https://github.com/rsp/ppj

    public static void main(String[] args) {

        int m = 5;

        for (int j = 0; j <= 2*m; j++) {
            for (int i = 0; i <= 2*m; i++)
                System.out.print((i-j)*(2*m-j-i) < 0 ? " " : "*");
            System.out.println();
        }

    }

}
