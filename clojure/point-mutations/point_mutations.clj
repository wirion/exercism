(ns point-mutations)

(defn hamming-distance [first-strand second-strand]
  (when (= (count first-strand) (count second-strand))
    (count (filter not (map = first-strand second-strand)))))
