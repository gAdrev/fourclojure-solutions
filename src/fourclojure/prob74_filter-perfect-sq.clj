(ns fourclojure.prob74)

(defn filter-perfect-squares [s]
  (let [nums (.split s ",")]
    (clojure.string/join
      ","
      (filter
        #(let [n (bigint %)
               sqr (bigint (Math/sqrt n))]
           (= (str (* sqr sqr)) %))
        nums))))


; Everything below should eval to true
(= (filter-perfect-squares "4,5,6,7,8,9") "4,9")
(= (filter-perfect-squares "15,16,25,36,37") "16,25,36")
