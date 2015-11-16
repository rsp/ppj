function eosort(t) {

    var b = [t.filter(x => x % 2 == 0).sort(),
             t.filter(x => x % 2).sort().reverse()],
        i = [0,0], r = t.map(x => b[x%2][i[x%2]++]);

    return r;

}

function printInts(t) {
    console.log(t.join(' '));
}

var t = [0,1,2,3,4,5,6,7,8,9];

printInts(t);

printInts(eosort(t));
