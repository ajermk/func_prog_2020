(ns kata.exercise2
  (:use [clojure.test]
        [kata.data]))

(testing "Sort by age (ascending)"

  ; Create a sequence with ascending ordered age values.
  (let [customers (:customers mall)
        customer-ages-sorted (sort (map :age customers))]

    (is (= (count customer-ages-sorted) 10))
    (is (= customer-ages-sorted [21, 22, 22, 26, 27, 28, 32, 35, 36, 38]))))


(testing "Sort by age (descending)"

  ; Create a sequence with descending ordered age values.
  (let [customers (:customers mall)
        customer-ages-sorted-desc (reverse (sort (map :age customers)))]

    (is (= (count customer-ages-sorted-desc) 10))
    (is (= customer-ages-sorted-desc [38, 36, 35, 32, 28, 27, 26, 22, 22, 21]))))


(testing "Top 3 rich customers"

  ; Create a sequence with top 3 rich customers by using (take ...)
  (let [customers (:customers mall)
        top-customers (take 3 (reverse (sort-by :budget customers)))]

    (is (= (count top-customers) 3))
    (is (= (map :name top-customers) ["Diana" "Andrew" "Chris"]))))

(testing "Distinct age"

  ; Create a sequence with distinct age values
  (let [customers (:customers mall)
        customer-ages (distinct (map :age customers))]

    (is (= (count customer-ages) 9))
    (is (= (set customer-ages) #{22, 27, 28, 26, 32, 35, 21, 36, 38}))))

(testing "Items customers want to buy"

  ; Create a sequence with items' names stored in :wants-to-buy, using (mapcat ...)
  (let [customers (:customers mall)
        wanted-items (map :name (mapcat :wants-to-buy customers ))]

    (is (= (count wanted-items) 32))
    (is (= wanted-items ["small table", "plate", "fork", "ice cream", "screwdriver", "cable", "earphone", "onion", "ice cream", "crisps", "chopsticks", "cable", "speaker", "headphone", "saw", "bond", "plane", "bag", "cold medicine", "chair", "desk",  "pants", "coat", "cup", "plate", "fork", "spoon", "ointment", "poultice", "spinach", "ginseng", "onion"]))))
