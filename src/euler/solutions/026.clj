(ns euler.solutions.026 "Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.")

(defn get-dec-rep [n]
  (let [frac (str (with-precision 3000 (/ 1M n)))]
    (if (> 3000 (count frac))
      nil
      (->> frac
        (#(subs % 2 (- (count %) 2)))
        (reverse)
        (clojure.string/join)
        (#(hash-map :n n :frac %)) ))))

(defn rec-cy-len [h]
  (let [frac (get h :frac)
        n (get h :n)]
    (loop [i 1]
      (if (> i (/ (count frac) 3))
        (hash-map :n n :cycle-len -1)
        (let [segments (partition i frac)]
          (if (= (nth segments 0) (nth segments 1) (nth segments 2))
            (hash-map :n n :cycle-len i)
            (recur (inc i)) ))))))

(->> (range 7 1000)
     (map get-dec-rep)
     (remove nil?)
     (map rec-cy-len)
     (apply max-key :cycle-len)
     (println "Solution 026:")
     (time))
