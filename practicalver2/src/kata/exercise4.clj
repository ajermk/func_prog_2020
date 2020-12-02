(ns kata.exercise4
  (:use [clojure.test]
        [kata.data]))

(testing "First registrant"

  ; Find the first customer
  (let [customers (:customers mall)
        first-customer (first customers)]

    (is (= (:name first-customer) "Joe"))))


(testing "Is there anyone older than 40?"

  ; Check whether any customer older than 40 exists or not by using (some ...)
  (let [customers (:customers mall)
        over40 (some #(> 40 %) (map :age customers))]

    (is (nil? over40))))

(testing "Is everybody older than 20?"

  ; Check whether all customer are older than 20 or not by using (every ...)
  (let [customers (:customers mall)
        over20 (every? #(< 20 %) (map :age customers))]

    (is (true? over20))))

(testing "Everyone wants something"

  ; Confirm that none of the customer has empty :wants-to-buy by using (not-any? ...)
  (let [customers (:customers mall)
        all-want-smth (not-any? #(> 0 %) (map count (map :name (mapcat :wants-to-buy customers))))]

    (is (true? all-want-smth))))
