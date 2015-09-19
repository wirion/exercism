(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn anagrams-for
  "Filters the list for candidate anagrams of word"
  [word candidates]
  (let [letter-count (frequencies (lower-case word))]
    (remove #(= (lower-case %) (lower-case word))
            (filter #(= letter-count (frequencies (lower-case %))) candidates))))
