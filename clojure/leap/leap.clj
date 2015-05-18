(ns leap)

(defn leap-year? [year]
  (and
   (= (mod year 4) 0)
   (or (= (mod year 400) 0)
       (not= (mod year 100) 0))))
