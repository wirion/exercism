(ns triangle)

(defn- valid? [triangle]
  (apply #(> (+ %1 %2) %3)
         (sort triangle)))

(defn type [a b c]
  {:pre [(every? number? [a b c])]}
  (let [triangle [a b c]]
    (if-not (valid? triangle)
      :illogical
      (let [same-sides (apply max (vals (frequencies triangle)))]
        (condp = same-sides
          3 :equilateral
          2 :isosceles
          :scalene)))))
