(ns yatzy-clj.yatzy
  (:gen-class))

(defn chance [dice]
  (reduce + dice))

(defn sum-dice [dice value]
  (reduce + (filter (fn [die] (= value die)) dice)))

(defn ones [dice] (sum-dice dice 1))

(defn twos [dice] (sum-dice dice 2))

(defn threes [dice] (sum-dice dice 3))

(defn fours [dice] (sum-dice dice 4))

(defn fives [dice] (sum-dice dice 5))

(defn sixes [dice] (sum-dice dice 6))

(defn count-value [dice value]
  (->> (filter (fn [die] (= value die)) dice)
       (count)))

(defn tally-die [dice]
  (map (fn [x] (count-value dice x)) (range 1 7)))

(defn is-count-at [dice i value]
 (= value (nth (tally-die dice) i)))

(defn get-first-tally [tallies value]
  (->> (range 0 6)
       (filter #(= value (nth tallies %)))
       (first)))

(defn yatzy [dice]
  (let [tallies (tally-die dice)]
    (if (= nil (get-first-tally tallies 5))
      0
      50)))

(defn three-of-a-kind [dice]
  (let [tallies (tally-die dice)]
    (->> (range 0 6)
         (filter #(> (nth tallies %) 2))
         (map (fn [x] (* (+ x 1) 3)))
         (first))))

