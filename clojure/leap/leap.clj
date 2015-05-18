(ns leap)

(defn- divisible-by [number divisor]
  (= (mod number divisor) 0))

(defn leap-year? [year]
  (and
   (divisible-by year 4)
   (or (divisible-by year 400)          ; makes use of short-circuiting
       (not (divisible-by year 100)))))
