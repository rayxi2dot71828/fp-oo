;;; Exercise 1
;; returns the second element of a list
(def second (fn [list] (nth list 1)))

;;; Exercise 2
;; returns the third element of a list
; first implementation
(def third (fn [list] (nth list 2)))

; second implementation
(def third (fn [list] (first (rest (rest list)))))

;;; Exercise 3
; what the name says
(def add-squares (fn [& args] (apply + (map * args args))))

;;; Exercise 4
; factorial without iteration or recursion
(def bizarre-factorial (fn [n] (apply * (range 1 (inc n)))))

;;; Exercise 5
;; my own version of take (http://clojuredocs.org/clojure_core/clojure.core/take)
(def my-take
  (fn [n coll]
    (if (or (empty? coll) (<= n 0))
      ()
      (cons (first coll) (my-take (dec n) (rest coll))))))
