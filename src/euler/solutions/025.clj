(ns euler.solutions.025 "What is the index of the first term in the Fibonacci sequence to contain 1000 digits?")

(def fib (lazy-cat [(bigint 1) 1] (map + fib (rest fib))))

(defn num-digits [n] (count (str n)))

(->> (take-while (fn [n] (< (num-digits n) 1000)) fib)
     (count)
     (inc)
     (println "Solution 025:")
     (time))
