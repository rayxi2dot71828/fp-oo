;;;; ==========================================================
;;; Exercise 1
;; returns the second element of a list
(def second (fn [list] (nth list 1)))

;;;; ==========================================================
;;; Exercise 2
;; returns the third element of a list
; first implementation
(def third (fn [list] (nth list 2)))

; second implementation
(def third (fn [list] (first (rest (rest list)))))

;;;; ==========================================================
;;; Exercise 3
; what the name says
(def add-squares (fn [& args] (apply + (map * args args))))

;;;; ==========================================================
;;; Exercise 4
; factorial without iteration or recursion
(def bizarre-factorial (fn [n] (apply * (range 1 (inc n)))))

;;;; ==========================================================
;;; Exercise 5

;; my filter (http://clojuredocs.org/clojure_core/clojure.core/filter)
(def my-filter
  (fn [pred coll]
    (if (empty? coll)
      ()
      (if (pred (first coll))
        (cons (first coll) (my-filter pred (rest coll)))
        (my-filter pred (rest coll))))))

;; my take (http://clojuredocs.org/clojure_core/clojure.core/take)
(def my-take
  (fn [n coll]
    (if (or (empty? coll) (<= n 0))
      ()
      (cons (first coll) (my-take (dec n) (rest coll))))))

;; Oops. I realized at this point that Brian is not asking us to implement the functions, but to use them!
;; Using the functions are open-ended, so I'm just going to look at his solutions for the rest of 
;; Exercise 5, to save time.

;;;; ==========================================================
;;; Exercise 6

;; prefix-of
; (or, you know, using take works too)
(def prefix-of?
  (fn [candidate sequence]
    (if (empty? candidate)
      true
      (if (= (first candidate) (first sequence))
        (and true (prefix-of? (rest candidate) (rest sequence)))
        false))))
    
    

