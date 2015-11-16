function mirror(s) {
    return s.split('').reverse().join('');
}

var s = "to be or not to be";

console.log("%s -> %s", s, mirror(s));
