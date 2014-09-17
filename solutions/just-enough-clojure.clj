;; returns the second element of a list
(def second (fn [list] (nth list 1)))

;; returns the third element of a list
; first implementation
(def third (fn [list] (nth list 2)))

; second implementation
(def third (fn [list] (first (rest (rest list)))))
