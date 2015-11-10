public class BitwiseOne {

    // https://github.com/rsp/ppj

    public static void main(String[] args) {

        int a, b;
        for (a=b=(1<<11)-1; a<1<<(11<<1); a<<=1,b>>=1)
            System.out.println(Integer.toString(
                (1<<11)|(a^b)&((1<<11)-1),1<<1).replace("1"," "));

    }

}
