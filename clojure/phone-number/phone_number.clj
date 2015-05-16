(ns phone-number)

(def ^:private invalid-number "0000000000")

(defn number [phone-number]
  (let [filtered-number (apply str (filter #(Character/isDigit %) phone-number))
        filtered-length (count filtered-number)]
    (if (and (= filtered-length 11)
             (= (Character/getNumericValue (get filtered-number 0)) 1))
      (subs filtered-number 1 11)
      (if (= filtered-length 10)
        filtered-number
        invalid-number))))

(defn area-code [phone-number]
  (let [normalized-number (number phone-number)]
    (subs normalized-number 0 3)))

(defn pretty-print [phone-number]
  (let [normalized-number (number phone-number)]
    (str "("
         (subs normalized-number 0 3)
         ") "
         (subs normalized-number 3 6)
         "-"
         (subs normalized-number 6 10))))
