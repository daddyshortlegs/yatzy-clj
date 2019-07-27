(ns yatzy-clj.yatzy-test
  (:require [clojure.test :refer :all]
            [yatzy-clj.yatzy :refer :all]))

(deftest chance_scores_sum_of_all_dice
  (is (= 15 (chance [2 3 4 5 1])))
  (is (= 16 (chance [3 3 4 5 1]))))

(deftest yatzy_scores_50
  (is (= 50 (yatzy [4 4 4 4 4])))
  (is (= 50 (yatzy [6 6 6 6 6])))
  (is (= 0 (yatzy [6 6 6 6 3]))))


(deftest test_1s
  (is (= 1 (ones [1 2 3 4 5])))
  (is (= 2 (ones [1 2 1 4 5])))
  (is (= 0 (ones [6 2 2 4 5])))
  (is (= 4 (ones [1 2 1 1 1]))))


(deftest test_2s
  (is (= 4 (twos [1 2 3 2 6])))
  (is (= 10 (twos [2 2 2 2 2]))))

(deftest test_3s
  (is (= 6 (threes [1 2 3 2 3])))
  (is (= 12 (threes [2 3 3 3 3]))))

(deftest test_4s
  (is (= 12 (fours [4 4 4 5 5 ])))
  (is (= 8 (fours [4 4 5 5 5])))
  (is (= 4 (fours [4 5 5 5 5]))))

(deftest test_5s
  (is (= 10 (fives [4 4 4 5 5 ])))
  (is (= 15 (fives [4 4 5 5 5])))
  (is (= 20 (fives [4 5 5 5 5]))))

(deftest test_6s
  (is (= 0 (sixes [4 4 4 5 5 ])))
  (is (= 6 (sixes [4 4 6 5 5])))
  (is (= 18 (sixes [6 5 6 6 5]))))


(deftest get_count_of_die
  (is (= [0 0 0 2 2 1] (tally-die [4 4 6 5 5]))))


(deftest one_pair
  (is (= 6 (pair [3 4 3 5 6 ])))
  (is (= 10 (pair [5 3 3 3 5])))
  (is (= 12 (pair [5 3 6 6 5]))))

(deftest test_three_of_a_kind
  (is (= 9 (three-of-a-kind [3 3 3 4 5])))
  (is (= 15 (three-of-a-kind [5 3 5 4 5])))
  (is (= 9 (three-of-a-kind [3 3 3 3 5]))))

(deftest test-four-of-a-kind
  (is (= 12 (four-of-a-kind [3 3 3 3 5])))
  (is (= 20 (four-of-a-kind [5 5 5 4 5 ]))))

(deftest test-small-straight
  (is (= 15 (small-straight [1 2 3 4 5])))
  (is (= 15 (small-straight [2 3 4 5 1])))
  (is (= 0 (small-straight [1 2 2 4 5]))))

;@Test
;public void two_Pair() {
;                        assertEquals(16, Yatzy.two_pair(3,3,5,4,5));
;                        assertEquals(16, Yatzy.two_pair(3,3,5,5,5));
;                        }
;
;


(deftest test-large-straight
  (is (= 20 (large-straight [6 2 3 4 5])))
  (is (= 20 (large-straight [2 3 4 5 6])))
  (is (= 0 (large-straight [1 2 2 4 5]))))

;(deftest test-full-house
;  (is (= 20 (full-house [6 2 2 2 6])))
;  (is (= 0 (full-house [2 3 4 5 6]))))

;@Test
;public void fullHouse() {
;  assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
;  assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
; }