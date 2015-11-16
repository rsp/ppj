PPJ
===
Random Java examples.

### BitwiseOne

[BitwiseOne.java](https://github.com/rsp/ppj/blob/master/BitwiseOne.java)
([download](https://raw.githubusercontent.com/rsp/ppj/master/BitwiseOne.java))

```java
int a, b;
for (a=b=(1<<11)-1; a<1<<(11<<1); a<<=1,b>>=1)
    System.out.println(Integer.toString(
        (1<<11)|(a^b)&((1<<11)-1),1<<1).replace("1"," "));
```

The result of running that program may not be obvious.
It uses two `int` variables, a single loop, a bunch of bitwise operators
and only digit `1` in literals.

### AbsoLoops

[AbsoLoops.java](https://github.com/rsp/ppj/blob/master/AbsoLoops.java)
([download](https://raw.githubusercontent.com/rsp/ppj/master/AbsoLoops.java))

```java
int m = 5;
for (int j = -m; j <= m; j++) {
    for (int i = 0; i-m <= Math.abs(j); i++)
        System.out.print(m-i > Math.abs(j) ? " " : "*");
    System.out.println();
}
```

Sometimes absolute values in loops can be useful.

### LoopArithmetic

[LoopArithmetic.java](https://github.com/rsp/ppj/blob/master/LoopArithmetic.java)
([download](https://raw.githubusercontent.com/rsp/ppj/master/LoopArithmetic.java))

```java
int m = 5;
for (int j = 0; j <= 2*m; j++) {
    for (int i = 0; i <= 2*m; i++)
        System.out.print((i-j)*(2*m-j-i) < 0 ? " " : "*");
    System.out.println();
}
```

Using arithmetic operations to simplify loops at the expense of readability.

### Mirror

[Mirror.java](https://github.com/rsp/ppj/blob/master/Mirror.java)
([download](https://raw.githubusercontent.com/rsp/ppj/master/Mirror.java))

```java
static String mirror(String s) {
    return mirror(s, "");
}
static String mirror(String s, String m) {
    return s.length() == 0 ? m :
        mirror(s.substring(1), s.substring(0,1) + m);
}
```

Using method overloading to simplify recursion.

Not as nice as [Mirror.js](https://github.com/rsp/ppj/blob/master/Mirror.js)
([download](https://raw.githubusercontent.com/rsp/ppj/master/Mirror.js)):

```js
function mirror(s) {
    return s.split('').reverse().join('');
}
```

but still pretty good for Java.

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
