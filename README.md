PPJ
===
Random Java examples:

* [BitwiseOne](#bitwiseone)
* [AbsoLoops](#absoloops)
* [LoopArithmetic](#looparithmetic)
* [StringsAndMirrors](#stringsandmirrors)
* [WhereEven](#whereeven)
* [TwoWaySort](#twowaysort)

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

### StringsAndMirrors

[StringsAndMirrors.java](https://github.com/rsp/ppj/blob/master/StringsAndMirrors.java)
([download](https://raw.githubusercontent.com/rsp/ppj/master/StringsAndMirrors.java))

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

Not as nice as [StringsAndMirrors.js](https://github.com/rsp/ppj/blob/master/StringsAndMirrors.js)
([download](https://raw.githubusercontent.com/rsp/ppj/master/StringsAndMirrors.js)):

```js
function mirror(s) {
    return s.split('').reverse().join('');
}
```

but still pretty good for Java.

### WhereEven

[WhereEven.java](https://github.com/rsp/ppj/blob/master/WhereEven.java)
([download](https://raw.githubusercontent.com/rsp/ppj/master/WhereEven.java))

```java
static int[] even(int[] t) {
    int i, j;
    for (i=j=0; i < t.length; i++)
        if (t[i] % 2 == 0) j++;
    int[] r = new int[j];
    for (i=j=0; i < t.length; i++)
        if (t[i] % 2 == 0) r[j++] = t[i];
    return r;
}
```
Returns an array with only even numbers. It's very hard to write in a less verbose way in Java because of poor support for higher order functions and no built-in filter method for arrays. For a comparison, here is the same in JS:

[WhereEven.js](https://github.com/rsp/ppj/blob/master/WhereEven.js)
([download](https://raw.githubusercontent.com/rsp/ppj/master/WhereEven.js))

```js
function even(t) {
    return t.filter(x => x % 2 == 0);
}
```

It's even better in Scheme:

[WhereEven.scm](https://github.com/rsp/ppj/blob/master/WhereEven.scm)
([download](https://raw.githubusercontent.com/rsp/ppj/master/WhereEven.scm))

```scheme
(define (even t)
    (filter even? t))
```
Not bad for a language that's 40 years old.

### TwoWaySort

[TwoWaySort.java](https://github.com/rsp/ppj/blob/master/TwoWaySort.java)
([download](https://raw.githubusercontent.com/rsp/ppj/master/TwoWaySort.java))

```java
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
```

This is a pretty compact way to do a two-way sorting of an array (even elements ascending and odd elements descending at the same time, preserving even/odd positions).

But what is written in Java in 19 lines (not including empty lines and the return statement) can be written in JS in just 3 lines:

[TwoWaySort.js](https://github.com/rsp/ppj/blob/master/TwoWaySort.js)
([download](https://raw.githubusercontent.com/rsp/ppj/master/TwoWaySort.js))

```js
function eosort(t) {

    var b = [t.filter(x => x % 2 == 0).sort(),
             t.filter(x => x % 2).sort().reverse()],
        i = [0,0], r = t.map(x => b[x%2][i[x%2]++]);

    return r;

}
```

Here is also an non-ES6 version of the above code that should conform to the original version of the language from 1997 (please [post an issue](https://github.com/rsp/ppj/issues) if that is not the case). The only difference is more cluttered syntax but there are still exactly the same expressions:

[TwoWaySort-es5.js](https://github.com/rsp/ppj/blob/master/TwoWaySort-es5.js)
([download](https://raw.githubusercontent.com/rsp/ppj/master/TwoWaySort-es5.js))

```js
function eosort(t) {

    var b = [t.filter(function(x){ return x % 2 == 0; }).sort(),
             t.filter(function(x){ return x % 2; }).sort().reverse()],
        i = [0,0], r = t.map(function(x){ return b[x%2][i[x%2]++]; });

    return r;

}
```

It seems impossible to implement it in Java in a way even remotely as compact as in JS, which seems strange for a language as mature and popular as Java. If anyone can improve the Java code to make it more compact, please [do a pull request](https://github.com/rsp/ppj/pulls) because I want that comparison to be fair.

That example was not chosen specifically to favour JS. It is a school example straight from a Java class.

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
