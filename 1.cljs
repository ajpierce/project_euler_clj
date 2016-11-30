#!/usr/bin/env planck

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
