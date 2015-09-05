(ns robot-name)

;; maybe use a random stream implementation?
(def ^:private letters (map char (range 65 91)))

(defn- random-letter []
  (rand-nth letters))

(defn- make-name []
  (str (random-letter)
       (random-letter)
       (format "%03d" (rand-int 1000))))

;; manufacture robot
(defn robot []
  (atom {:name (make-name)}))

(defn robot-name [robot] (:name @robot))

(defn reset-name [robot]
  (swap! robot assoc :name (make-name)))
