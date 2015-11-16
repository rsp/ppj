function even(t) {
    return t.filter(function(x){ return x % 2 == 0; });
}

function printInts(t) {
    console.log(t.join(' '));
}

var t = [0,1,2,3,4,5,6,7,8,9];
printInts(t);
var p = even(t);
printInts(p);
