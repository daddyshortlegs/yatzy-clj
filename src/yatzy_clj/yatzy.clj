(ns yatzy-clj.yatzy
  (:gen-class))

(defn chance [dice]
  (reduce + dice)
  )

;public static int yatzy(int... dice)
;{
; int[] counts = new int[6];
;    for (int die : dice)
;    counts[die-1]++;
; for (int i = 0; i != 6; i++)
;          if (counts[i] == 5)
;          return 50;
;          return 0;
; }

(defn sum-dice [dice value]
  (reduce + (filter (fn [die] (= value die)) dice)))

(defn ones [dice] (sum-dice dice 1))

(defn twos [dice] (sum-dice dice 2))

(defn threes [dice] (sum-dice dice 3))

(defn fours [dice] (sum-dice dice 4))

(defn fives [dice] (sum-dice dice 5))

(defn sixes [dice] (sum-dice dice 6))


(defn count-value [dice value]
  (count (filter (fn [die] (= value die)) dice)))

(defn tally-die [dice]
  [
   (count-value dice 1)
   (count-value dice 2)
   (count-value dice 3)
   (count-value dice 4)
   (count-value dice 5)
   (count-value dice 6)
   ]
  )


;        int at;
;        for (at = 0; at < 6; at++)
;            if (counts[6 - at - 1] >= 2)
;                return (6 - at)*2;
;        return 0;

(defn score_pair [dice]
  (filter (fn [count] ) (tally-die dice))
  )



