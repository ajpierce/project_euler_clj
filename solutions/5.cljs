#!/usr/bin/env planck
(ns solutions.five
  "Problem 5
    2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?"
  (:require [euler.common :refer [prime-factors, pow]]) )

(defn solution [start end]
  (->> (range start (inc end))
       (map prime-factors)
       (map frequencies)
       (apply merge-with max)
       (into [])  ; Convert map into vector of key-value pair vectors
       (map #(pow (first %) (last %)))
       (reduce *) ))

(time (println "1-10:" (solution 1 10)))
(time (println "1-20:" (solution 1 20)))
