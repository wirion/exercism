(ns space-age)

(def ^:private earth-orbital-period 31557600)

(def ^:private relative-periods
  {:mercury 0.2408467
   :venus 0.61519726
   :mars 1.8808158
   :earth 1
   :jupiter 11.862615
   :saturn 29.447498
   :uranus 84.016846
   :neptune 164.79132})

(def ^:private periods
  (into {} (for [[k v] relative-periods] [k (#(* earth-orbital-period %) v)])))

(defn- compute-age [planet, seconds]
  (let [orbital-period (periods planet)]
    (double (/ seconds orbital-period))))

(defn on-mercury [seconds]
  (compute-age :mercury seconds))
(defn on-venus [seconds]
  (compute-age :venus seconds))
(defn on-earth [seconds]
  (compute-age :earth seconds))
(defn on-mars [seconds]
  (compute-age :mars seconds))
(defn on-jupiter [seconds]
  (compute-age :jupiter seconds))
(defn on-saturn [seconds]
  (compute-age :saturn seconds))
(defn on-uranus [seconds]
  (compute-age :uranus seconds))
(defn on-neptune [seconds]
  (compute-age :neptune seconds))
