(ns triangle)

(defn type [side-a side-b side-c]
  {:pre [(every? number? [side-a side-b side-c])]})
