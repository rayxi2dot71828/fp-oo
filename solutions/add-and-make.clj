;;;; This file is copied from https://github.com/marick/fp-oo/blob/master/sources/add-and-make.clj
;;;; The exercise is to add more code to the already existing code here, as per the book.
;;;; From Chapter "A Barely Believable Object"

(def point {:x 1, :y 2, :__class_symbol__ 'Point})

(def Point
     (fn [x y]
       {:x x,
        :y y
        :__class_symbol__ 'Point}))

(def x :x)
(def y :y)
(def class-of :__class_symbol__)

(def shift
     (fn [this xinc yinc]
       (Point (+ (x this) xinc)
              (+ (y this) yinc))))

(def Triangle
     (fn [point1 point2 point3]
       {:point1 point1, :point2 point2, :point3 point3
        :__class_symbol__ 'Triangle}))


(def right-triangle (Triangle (Point 0 0)
                              (Point 0 1)
                              (Point 1 0)))

(def equal-right-triangle (Triangle (Point 0 0)
                                    (Point 0 1)
                                    (Point 1 0)))

(def different-triangle (Triangle (Point 0 0)
                                  (Point 0 10)
                                  (Point 10 0)))


;;;; ==========================================================
;;; Exercise 1

;;; Implement add to add two points
;;; The first version doesn't use shift
(def add
  (fn [this another-point]
    (Point
      (+ (x this) (x another-point))
      (+ (y this) (y another-point)))))

;;; This one uses shift
(def add-with-shift
  (fn [this another-point]
    (let [new-point (shift this (x another-point) (y another-point))]
    (Point (x new-point) (y new-point)))))

;;;; ==========================================================
;;; Exercise 2

;;; Implement a "new" operator
;;; Since "new" is reserved in Clojure, we're calling it "make"
(def make
  (fn [constructor & args]
    (apply constructor args)))

;;;; ==========================================================
;;; Exercise 3 & 4

;;; Implement equal-triangles? to compare triangles produced by
;;; the three factory functions above
(def equal-triangles?
  (fn [& triangles]
    (apply = triangles)))

;;;; ==========================================================
;;; Exercise 5

;;; Implement valid-triangle? (Just checks for dupes)
(def valid-triangle?
  (fn [& points]
    (and
      (= 3 (count points))
      (apply distinct? points))))
