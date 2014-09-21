;;;; This file is copied from https://github.com/marick/fp-oo/blob/master/sources/embedded-functions.clj
;;;; The exercise is to add more code to the already existing code here, as per the book.
;;;; From Chapter "All the Class in a Constructor"

(def make
     (fn [type & args]
       (apply type args)))

(def send-to
     (fn [object message & args]
       (apply (message (:__methods__ object)) object args)))

; Uh, I just checked Brian's solution. Mine's way too overcomplicated :-S
(def Point
  (fn [x y]
    {:x x,
     :y y
     :__class_symbol__ 'Point
     :__methods__ {
                    :class :__class_symbol__
                    :shift (fn [this xinc yinc]
                             (make Point (+ (send-to this :x) xinc)
                               (+ (send-to this :y) yinc)))
                    ; One exercise: accessors
                    :getter (fn [this member] (get this member))
                    :x (fn [this] (send-to this :getter :x))
                    :y (fn [this] (send-to this :getter :y))}}))
