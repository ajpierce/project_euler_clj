#!/usr/bin/env planck
(ns solutions.six
  "Problem 6:
    Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum."
  (:require [math.primes :refer [pow]]) )

(defn solution [start end]
  (let [r (range start (inc end))
        sum-of-squares (apply + (map #(pow % 2) r))
        square-of-sum (pow (apply + r) 2)]
    (- square-of-sum sum-of-squares)))

(time (println "1-10:" (solution 1 10)))
(time (println "1-100:" (solution 1 100)))
