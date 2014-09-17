;; returns the second element of a list
(def second (fn [list] (nth list 1)))

;; returns the third element of a list
; first implementation
(def third (fn [list] (nth list 2)))

; second implementation
(def third (fn [list] (first (rest (rest list)))))

; what the name says
(def add-squares (fn [& args] (apply + (map * args args))))

; factorial without iteration or recursion
(def bizarre-factorial (fn [n] (apply * (range 1 (inc n)))))

