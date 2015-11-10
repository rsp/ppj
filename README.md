PPJ
===
Random Java examples.

Bitwise operators
-----------------

### BitwiseOne

[BitwiseOne.java](https://github.com/rsp/ppj/blob/master/BitwiseOne.java)

```java
int a, b;
for (a=b=(1<<11)-1; a<1<<(11<<1); a<<=1,b>>=1)
    System.out.println(Integer.toString(
        (1<<11)|(a^b)&((1<<11)-1),1<<1).replace("1"," "));
```

The result of running that program may not be obvious.
It uses two `int` variables, a single loop and only digit `1` in literals.

### AbsLoops

[AbsLoops.java](https://github.com/rsp/ppj/blob/master/AbsLoops.java)

```java
int m = 5;
for (int j = -m; j <= m; j++) {
    for (int i = 0; i-m <= Math.abs(j); i++)
        System.out.print(m-i > Math.abs(j) ? " " : "*");
    System.out.println();
}
```

Sometimes absolute values in loops can be useful.

Download
--------
Latest version in a ZIP file:

[https://github.com/rsp/ppj/archive/master.zip](https://github.com/rsp/ppj/archive/master.zip)

Issues
------
For any bugs please [post an issue](https://github.com/rsp/ppj/issues).

Author
------
Rafał Pocztarski - [https://github.com/rsp](https://github.com/rsp)

License
-------
MIT License (Expat). See [LICENSE.md](LICENSE.md) for details.
