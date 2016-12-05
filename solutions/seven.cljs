#!/usr/bin/env planck
(ns solutions.seven
  "Problem 7:
  By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
  What is the 10001st prime number?"
  (:require [common.math :refer [primes]]) )

(time (println (nth (sort (primes 120000)) 10000)))
