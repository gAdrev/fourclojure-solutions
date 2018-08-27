(ns fourclojure.prob65)

(defn bbt [coll]
  (let [sym1 (gensym)
        sym2 (gensym)
        tester [sym1 sym2]
        conjed (conj (conj coll [(gensym) (gensym)]) tester)]
    (cond
      (= (get conjed sym1) sym2) :map
      (= (get conjed tester) tester) :set
      (= (nth conjed 0) tester) :list
      :else :vector )))

; Everything below should eval to true
(= :map (bbt {:a 1, :b 2}))
(= :list (bbt (range (rand-int 20))))
(= :vector (bbt [1 2 3 4 5 6]))
(= :set (bbt #{10 (rand-int 5)}))
(= [:map :set :vector :list] (map bbt [{} #{} [] ()]))
