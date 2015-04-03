(ns word-count
  (:require [clojure.string :refer [split lower-case]]))

(defn- lowercase-tokenize [sentence]
  (map lower-case (split sentence #"[^\p{L}\p{Digit}]+")))

(defn- tally-up [count-map word]
  (assoc count-map word (let [word-count (count-map word)]
                     (if word-count
                       (inc word-count)
                       1))))

(defn word-count [sentence]
  (let [count-map {}
        tokens (lowercase-tokenize sentence)]
    (reduce tally-up count-map tokens)))
