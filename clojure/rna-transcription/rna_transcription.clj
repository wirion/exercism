(ns rna-transcription)

(def ^:private rna-translation-map
  {\C \G
   \G \C
   \A \U
   \T \A})

(defn- valid-dna? [dna-string]
  (re-matches #"[CGAT]*" dna-string))

(defn- to-rna-char [dna-char]
  (rna-translation-map dna-char))

(defn to-rna [dna-string]
  {:pre [(valid-dna? dna-string)]}
  (apply str (map to-rna-char dna-string)))
