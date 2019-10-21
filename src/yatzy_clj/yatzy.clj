(ns yatzy-clj.yatzy
  (:gen-class))

(defn chance [dice]
  (reduce + dice))

(defn sum-dice [dice value]
  (reduce + (filter #(= value %) dice)))

(defn ones [dice] (sum-dice dice 1))

(defn twos [dice] (sum-dice dice 2))

(defn threes [dice] (sum-dice dice 3))

(defn fours [dice] (sum-dice dice 4))

(defn fives [dice] (sum-dice dice 5))

(defn sixes [dice] (sum-dice dice 6))

(defn count-value [dice value]
  (->> (filter #(= value %) dice)
       (count)))

(defn tally-die [dice]
  (map #(count-value dice %) (range 1 7)))

(defn get-first-tally [tallies value]
  (->> (range 0 6)
       (filter #(= value (nth tallies %)))
       (first)))

(defn yatzy [dice]
  (let [tallies (tally-die dice)]
    (if (nil? (get-first-tally tallies 5))
      0
      50)))

(defn pair [dice]
  (let [tallies (tally-die dice)
        result (->> (range 0 5)
                    (map (fn [i] (- 5 i)))
                    (filter #(> (nth tallies %) 1))
                    (map #(* (+ % 1) 2))
                    (first))]
    (if (nil? result) 0 result)))

(defn two-pair [dice]
  (let [tallies (tally-die dice)
        result (->> (range 0 6)
                    (filter #(>= (nth tallies (- 6 % 1)) 2))
                    (map #(- 6 %))
                    (reduce +)
                    (* 2))]
    (if (nil? result) 0 result)))

(defn x-of-a-kind [dice x]
  (let [tallies (tally-die dice)
        result (->> (range 0 6)
                    (filter #(>= (nth tallies %) x))
                    (map #(* (+ % 1) x))
                    (first))]
    (if (nil? result) 0 result)))

(defn three-of-a-kind [dice]
  (x-of-a-kind dice 3))

(defn four-of-a-kind [dice]
  (x-of-a-kind dice 4))

(defn straight [dice start end]
  (->> (range start end)
       (filter #(not= (nth (tally-die dice) %) 1))
       (map (fn [x] 0))
       (first)))

(defn small-straight [dice]
  (if (nil? (straight dice 0 5)) 15 0))

(defn large-straight [dice]
  (if (nil? (straight dice 1 6)) 20 0))

(defn full-house [dice]
  (+ (pair dice) (three-of-a-kind dice)))