(ns kata.exercise1
  (:use [clojure.test],
        [kata.data]))

(testing "Find-rich-customers"

  ; Create a sequence of customers having more budget than 10000
  (let [customers (:customers mall)
        rich-customers  (filter #(> (:budget %) 10000) customers)]

    (is (= (count rich-customers) 2))
    (is (= (set (map :name rich-customers)) #{"Diana" "Andrew"}))))


;;
;
(testing "How old are the customers"

         ; Create a sequence of customer ages
         (let [customers (:customers mall)
               customer-ages (map :age customers)]

           (is (= (count customer-ages) 10))
           (is (= customer-ages [22, 27, 28, 38, 26, 22, 32, 35, 21, 36]))))



