(ns kata.exercise7
  (:use [clojure.test]
        [kata.data]))

(testing "Average Age"

  ; Calculate the average of customer ages by using your own (avg ...)
  ;; Don't forget about (apply ...)
  (let [customers (:customers mall)
        ages (map :age customers)
        num-of-cust (count customers)
        avg-age (/  (reduce + ages) num-of-cust )]

    (is (= avg-age (rationalize 28.7)))))


(testing "How Much for Everything?!"

  ; Calculate the sum of the prices for all the items in all shops by using (flatten ...)
  ;; Don't forget about (apply ...)
  (let [shops (:shops mall)

        total (reduce + (map :price (mapcat :items shops)))]

    (is (= total 60930))))
