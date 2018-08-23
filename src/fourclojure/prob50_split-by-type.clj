(ns fourclojure.prob50)

(defn type-grouper [coll]
  (vals (reduce
          (fn willy [acc val]
            (if (contains? acc (type val))
              (update-in acc [(type val)] #(conj % val))
              (conj acc {(type val) [val]})))
          {}
          coll)))

; Everything below should eval to true
(= (set (type-grouper [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
(= (set (type-grouper [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
(= (set (type-grouper [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
