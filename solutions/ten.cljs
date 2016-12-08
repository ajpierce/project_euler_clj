#!/usr/bin/env planck
(ns solutions.ten
  "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
  Find the sum of all the primes below two million."
  (:require [math.primes :refer [primes]]) )

(time (println (apply + (primes 2000000))))
