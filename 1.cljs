#!/usr/bin/env planck
;;;;;;;;;;
;  If we list all the natural numbers below 10 that are multiples of 3 or 5, we
;  get 3, 5, 6 and 9. The sum of these multiples is 23.
;
;  Find the sum of all the multiples of 3 or 5 below 1000.
;;;;;;;;;;

(defn mod3or5? [number]
  (or
    (= 0 (mod number 3))
    (= 0 (mod number 5))))

(defn solution [rangeLimit]
  ( ->> (range rangeLimit)
      (filter #(mod3or5? %))
      (reduce +)))

(println "Sum of all multiples of 3 and 5 below 10? " (solution 10))
(println "Sum of all multiples of 3 and 5 below 1000? " (solution 1000))
