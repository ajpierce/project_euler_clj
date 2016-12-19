(ns euler.solutions.010
  "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
  Find the sum of all the primes below two million."
  (:require [euler.math.primes :refer [primes]]) )

(->> (primes 2000000)
     (apply +)
     (println "Solution 010:")
     (time))
