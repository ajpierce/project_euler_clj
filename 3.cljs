#!/usr/bin/env planck
;;;;;;;;;;
;  The prime factors of 13195 are 5, 7, 13 and 29.
;
;  What is the largest prime factor of the number 600851475143 ?
;;;;;;;;;;

(defn factor? [number candidate]
  (zero? (mod number candidate)) )

(defn prime? [number]
  (if (or (even? number) (< number 2)) false  ; Immediately reject if our number is even or less than 2
    (let [root (int (Math/sqrt number))]      ; Redundant to check for factors > square root of the number
      (loop [i 3]                             ; Start checking for factors starting at 3
        (if (> i root) true                   ; Base case: we've iterated through every possible factor; it's prime
          (if (factor? number i) false        ; If we find a factor, the number is not prime
            (recur (+ i 2))))))))             ; Recurse and try the next (odd) number

; Check for primes beginning at half the number, exiting when we find the first one
(defn solution [number]
  (loop [candidate (quot number 2)]
    (if (and (odd? candidate) (factor? number candidate) (prime? candidate))
      candidate
      (recur (- candidate 1)) )))

(defn solution2 [number]
  (->> (range 3 (quot number 2))
       (filter odd?)
       (filter #(factor? number %))
       (filter prime?)
       (apply max)
       ))

(defn solution3 [number]
  (let [usb (long (Math/sqrt number))]  ; The upper search bounds is the square root of the number
    (loop [n number i 2]
      (cond
        (> i usb) n
        (= i n) n
        (factor? n i) (recur (/ n i) i)
        true (recur n (inc i)) ))))


(println "Solution 1" (time (solution 6008514)))
(println "Solution 2" (time (solution2 6008514)))
(println "Solution 3" (time (solution3 6008514)))

(let [number 600851475143]
  (println "Largest prime candidate of" number "is:" (time (solution3 number))) )
