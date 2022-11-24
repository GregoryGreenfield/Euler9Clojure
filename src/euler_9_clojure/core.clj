(ns euler-9-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; Euler 9 solution in Clojure
;A Pythagorean triplet is a set of three natural numbers, a < b < c, for which a2 + b2 = c2
;For example, 32 + 42 = 9 + 16 = 25 = 52.
;There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.

; returns the value for a
(defn get-a [b]
  (/ (- (* 2 1000 b) (* 1000 1000)) (- (* 2 b) (* 2 1000))))

; returns the value for c
(defn get-c [a b]
  (- 1000 a b))

; pass in prospective a, b and c and determine whether they equal 1000
(defn is-triplet [a b c]
  (= 1000 (+ a b c)))

; function that brute forces through a selection of b values until is-triplet returns a true. Then it returns a value
; Answer is 200, 375, 425
(defn compute[] 
  (loop [b 1]
    (when (< b 501)
      (if (and (is-triplet (get-a b) b (get-c (get-a b) b)) (int? (get-a b)) (int? (get-c (get-a b) b)))
        (println "Values are equal" (get-a b) b (get-c (get-a b) b) "multiplied:" (* (get-a b) b (get-c (get-a b) b)))
        ;(println "Not equal" (get-a b) b (get-c (get-a b) b))
        )
      (recur (+ b 1)))))
(compute)
; This program calculates the same thing multiple times per loop. Is there a way to make this just once?