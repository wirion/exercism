(ns rna-transcription)

(def ^:private dna->rna
  {\C \G
   \G \C
   \A \U
   \T \A})

(defn- valid-dna? [dna-string]
  (re-matches #"[CGAT]*" dna-string))

(defn to-rna [dna-string]
  {:pre [(valid-dna? dna-string)]}
  (apply str (map dna->rna dna-string)))
