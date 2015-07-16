(ns grains
  (:require [clojure.math.numeric-tower :as math]))

(defn square [number]
  (math/expt (bigint 2) (- number 1)))

(defn total []
  (apply + (for [i (range 1 65)] (square i))))
