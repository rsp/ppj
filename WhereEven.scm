(define (even t)
    (filter even? t))

(define (print-ints t)
    (display t) (newline))

(define t (list 0 1 2 3 4 5 6 7 8 9))
(print-ints t)
(define p (even t))
(print-ints p)
