(ns linkedlist.core
  (:gen-class)
  (:require [clj-http.client :as client]
            [clojure.java.io :refer [as-url]]))

(def ^:private base-url "http://www.pythonchallenge.com/pc/def/linkedlist.php")

(defn- fetch-data [n]
  (client/get base-url {:query-params {:nothing n}}))

(defn- follow-data [n]
  (try
    (let [body (:body (fetch-data n))
          next-n (Integer/valueOf (last (first (re-seq #"and the next nothing is (-{0,1}\d+)" body))))]
      (cons n (lazy-seq (follow-data next-n))))
    (catch NumberFormatException e (cons n nil))))

(defn -main []
  (let [checkpoint (last (take 86 (follow-data 12345)))]
  (println (str base-url "?nothing=" (last (take 165 (follow-data (unchecked-divide-int checkpoint 2))))))))

; Need to make 86 calls in total to get the first checkpoint
; (def checkpoint (nth (follow-data 12345) 85))

; Then start from half the checkpoint and make 165 calls in total to get the answer
; (def answer (nth (follow-data (unchecked-divide-int checkpoint 2)) 164))
