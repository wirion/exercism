(ns grade-school)

(defn add [db name grade-number]
  (merge-with into db {grade-number [name]}))

(defn grade [db grade-number]
  (get db grade-number []))

(defn sorted [db]
  (into (sorted-map) (for [[grade students] db] [grade (sort students)])))
