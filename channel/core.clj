(ns channel.core
  (:import [java.util.zip.ZipFile]))

(def ^:private zip-file (java.util.zip.ZipFile. "channel.zip"))
(def ^:private entries (enumeration-seq (.entries zip-file)))

(println (slurp (. zip-file getInputStream (. zip-file getEntry "readme.txt"))))

(comment
(defn- fetch-data [n]
  (client/get base-url {:query-params {:nothing n}}))

(defn- follow-data [n]
  (try
    (let [body (:body (fetch-data n))
          next-n (Integer/valueOf (last (first (re-seq #"and the next nothing is (-{0,1}\d+)" body))))]
      (cons n (lazy-seq (follow-data next-n))))
    (catch NumberFormatException e (cons n nil))))

(def count ))
