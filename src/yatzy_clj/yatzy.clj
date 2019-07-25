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


(defn ones [dice]
  (reduce + (filter (fn [die] (= 1 die)) dice)))

(defn twos [dice]
  (reduce + (filter (fn [die] (= 2 die)) dice)))



