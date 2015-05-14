(ns beer-song)

(defn- n-bottle-verse [bottle-count]
  (str bottle-count " bottles of beer on the wall, " bottle-count " bottles of beer.\nTake one down and pass it around, " (dec bottle-count) " bottles of beer on the wall.\n"))

(defn- two-bottle-verse []
  "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n")

(defn- one-bottle-verse []
  "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n")

(defn- zero-bottle-verse []
  "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")

(comment "validate that bottle-count is a number")
(defn verse [bottle-count]
  (cond
    (= bottle-count 2) (two-bottle-verse)
    (= bottle-count 1) (one-bottle-verse)
    (= bottle-count 0) (zero-bottle-verse)
    :else (n-bottle-verse bottle-count)))

(comment "validate that start-bottle-count is bigger than end-bottle-count")
(defn sing
  ([start-bottle-count end-bottle-count]
   (str
    (verse start-bottle-count)
    (apply str
           (for [bottle-count (range (dec start-bottle-count) (dec end-bottle-count) -1)]
             (str "\n" (verse bottle-count))))))
  ([bottle-count]
   (sing bottle-count 0)))
