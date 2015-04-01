(ns rna-transcription)

(def ^:private rna-translation-map
  {\C \G
   \G \C
   \A \U
   \T \A})

(defn- valid-dna? [dna-string]
  (if (re-matches #"[CGAT]*" dna-string)
    true
    false))

(defn to-rna [dna-string]
  {:pre [(or (valid-dna? dna-string) (throw (AssertionError. "Non-valid DNA string.")))]}
  (doall (apply str (map
                     (fn [character] (rna-translation-map character))
                     dna-string))))
