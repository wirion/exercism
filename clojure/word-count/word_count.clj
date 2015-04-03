(ns word-count
  (:require [clojure.string :refer [split lower-case]]))

(defn- lowercase-tokenize [sentence]
  (map lower-case (split sentence #"[^\p{L}\p{Digit}]+")))

(defn word-count [sentence]
  (frequencies (lowercase-tokenize sentence)))
