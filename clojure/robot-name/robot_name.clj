(ns robot-name)

(def ^:private robot-park (atom []))

;; maybe use a random stream implementation?
(defn- random-letter []
  (char (+ 65 (rand-int 25))))

(defn- make-name []
  (str (random-letter)
       (random-letter)
       (format "%03d" (rand-int 1000))))

;; manufacture robot
(defn robot []
  (let [new-robot {:name (make-name)}]
    (swap! robot-park conj new-robot)
    new-robot))

(defn robot-name [robot] (:name robot))

(defn- find-index [robot-park robot]
  (.indexOf robot-park robot))

(defn reset-name [robot]
  (let [robot-index (find-index @robot-park robot)]
    (swap! robot-park update-in [robot-index :name] #(do % (make-name)))))
