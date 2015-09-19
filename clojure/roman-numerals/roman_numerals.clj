(ns roman-numerals
  (:require [clojure.string :refer [split]]))

(def ^:private ones
  {0 ""
   1 "I"
   2 "II"
   3 "III"
   4 "IV"
   5 "V"
   6 "VI"
   7 "VII"
   8 "VIII"
   9 "IX"})

(def ^:private tens
  {0 ""
   1 "X"
   2 "XX"
   3 "XXX"
   4 "XL"
   5 "L"
   6 "LX"
   7 "LXX"
   8 "LXXX"
   9 "XC"})

(def ^:private hundreds
  {0 ""
   1 "C"
   2 "CC"
   3 "CCC"
   4 "CD"
   5 "D"
   6 "DC"
   7 "DCC"
   8 "DCCC"
   9 "CM"})

(def ^:private thousands
  {0 ""
   1 "M"
   2 "MM"
   3 "MMM"})

(defn numerals
  "Convert Arabic numbers to Roman numbers"
  [arabic-number]
  {:pre [(pos? arabic-number)
         (< arabic-number 3900)]}
  (->> (format "%04d" arabic-number)
       (#(split % #""))
       (map read-string)
       (apply #(do [(thousands %1) (hundreds %2) (tens %3) (ones %4)]))
       (apply str)))
