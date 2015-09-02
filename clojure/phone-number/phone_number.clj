(ns phone-number
  (require [clojure.string :as s]))

(def ^:private invalid-number "0000000000")

(defn number [phone-number]
  (let [filtered-number (s/replace phone-number #"\D" "")
        filtered-length (count filtered-number)]
    (condp apply [filtered-length]
      #(and (= % 11) (= (first filtered-number) \1)) (subs filtered-number 1)
      #(= % 10) filtered-number
      invalid-number)))

(defn area-code [phone-number]
  (-> phone-number
      number
      (subs 0 3)))

(defn pretty-print [phone-number]
  (let [normalized-number (number phone-number)]
    (apply format "(%s) %s-%s"
           (map #(apply subs normalized-number %)
                [[0 3] [3 6] [6 10]]))))
