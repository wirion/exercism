(ns phone-number)

(def ^:private invalid-number "0000000000")

(defn number [phone-number]
  (let [filtered-number (apply str (filter #(Character/isDigit %) phone-number))
        filtered-length (count filtered-number)]
    (cond (and (= filtered-length 11)
               (= (first filtered-number) \1)) (subs filtered-number 1)
          (= filtered-length 10) filtered-number
          :else invalid-number)))

(defn area-code [phone-number]
  (-> phone-number
      number
      (subs 0 3)))

(defn pretty-print [phone-number]
  (let [normalized-number (number phone-number)]
    (apply format "(%s) %s-%s"
           (map #(apply subs normalized-number %)
                [[0 3] [3 6] [6 10]]))))
