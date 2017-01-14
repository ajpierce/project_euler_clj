(ns euler.solutions.033
  "The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

  We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

  There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

  If the product of these four fractions is given in its lowest common terms, find the value of the denominator."
  (:require [euler.common :refer [parse-int split-int]]) )

(defn common-digit
  "Finds the common digit shared by n1 and n2
  e.g., [12 23] => 2;  [32 84] => nil"
  ([coll] (common-digit (first coll) (last coll)))
  ([n1 n2]
   (let [s1 (set (clojure.string/split (str n1) #""))
         s2 (set (clojure.string/split (str n2) #""))]
     (clojure.set/intersection s1 s2) )))

(defn common-digit?
  "Determines if there is a digit shared by n1 and n2.
  e.g., [12 23] => true;  [32 84] => false"
  ([coll] (common-digit? (first coll) (last coll)))
  ([n1 n2] (not (empty? (common-digit n1 n2))) ))

(defn contains-zero? [n] (clojure.string/includes? (str n) "0"))

(defn digit-repeats? [n]
  (let [digits (clojure.string/split (str n) #"")]
    (< (count (set digits)) (count digits) )))

(def possible-fractions
  (for [d (range 11 100)
        n (range 10 d)
        :when (and (not (contains-zero? d))
                   (not (contains-zero? n))
                   (not (digit-repeats? n))
                   (not (digit-repeats? d))
                   (common-digit? n d))]
    [n d] ))

(defn get-ratio
  ([coll] (get-ratio (first coll) (last coll)))
  ([n d] (/ n d)) )

(defn remove-digit [n d]
  (->> n split-int (remove #(= % (parse-int d))) first))

(defn simplify
  ([coll] (simplify (first coll) (last coll)))
  ([n d]
   (let [cd (first (common-digit n d))
         x (remove-digit n cd)
         y (remove-digit d cd)]
     [x y] )))

(defn special-fraction?
  ([coll] (special-fraction? (first coll) (last coll)))
  ([n d]
   (= (get-ratio n d) (get-ratio (simplify n d))) ))

(->> possible-fractions
     (filter special-fraction?)
     (map simplify)
     (map #(apply / %))
     (reduce *)
     (println "Solution 033:")
     (time))
