(ns euler.solutions.22
  "Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

  For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

  What is the total of all the name scores in the file?"
  (:require [clojure.string :as string])
  (:require [clojure.java [io :as io]]) )

(def letters (map char (range 65 91)))

(defn nth-of-alphabet [a]
  (inc (.indexOf letters a)))

(defn value-of-name [i s]
  (->> s
       (char-array)
       (map nth-of-alphabet)
       (reduce +)
       (* (inc i))))

(with-open [f (io/reader "./src/euler/problems/p022_names.txt")]
  (let [names (->> (line-seq f)
                   (first)
                   (#(string/split % #"\,"))
                   (into (sorted-set)) )]
    (->> names
         (map-indexed value-of-name)
         (reduce +)
         (println)
         (time))))