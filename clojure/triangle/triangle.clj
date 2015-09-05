(ns triangle)

(defn- valid? [side-a side-b side-c]
  (apply #(> (+ %1 %2) %3) (sort [side-a side-b side-c])))

(defn type [side-a side-b side-c]
  {:pre [(every? number? [side-a side-b side-c])]}
  (if (not (valid? side-a side-b side-c))
    :illogical
    (let [side-counts (vals (frequencies [side-a side-b side-c]))]
      (condp #(some #{%1} %2) side-counts
        3 :equilateral
        2 :isosceles
        :scalene))))
