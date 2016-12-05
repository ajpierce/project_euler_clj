#!/usr/bin/env planck
;;;;;;;;;;
;  The prime factors of 13195 are 5, 7, 13 and 29.
;
;  What is the largest prime factor of the number 600851475143 ?
;;;;;;;;;;
(ns solutions.three
  (:require [euler.common :refer [factor?]]) )

(defn solution [number]
  (let [usb (long (Math/sqrt number))]  ; The upper search bounds is the square root of the number
    (loop [quotient number              ; Begin searching for factors of the number with the number
           divisor 2]                   ; Possible divisors begin at 2
      (cond
        (> divisor usb) quotient        ; If our divisor passes our upper search bounds, our current quotient is the largest prime factor
        (= divisor quotient) quotient   ; If our divisor is equal to our quotient, we've found the largest prime factor (a square)
        (factor? quotient divisor) (recur (/ quotient divisor) divisor) ; Update our quotient and recurse because we found a factor
        true (recur quotient (inc divisor)) ))))                        ; Otherwise, recurse with a higher divisor


(time (let [number 600851475143]
  (println "Largest prime candidate of" number "is:" (solution number)) ))
