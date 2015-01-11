(ns embang.runtime-test
  (:require [clojure.test :refer [deftest testing is]])
  (:use embang.runtime))

(deftest test-categorical
  (testing "categorical"
    (let [dist (categorical '((x 1) (y 2)))]
      (is (= (observe dist 'x) (Math/log (/ 1. 3.)))
          "observing value in support")
      (is (= (observe dist 'z) (Math/log 0.))
          "observing value not in support"))))

(deftest test-cov
  (testing "cov"
    (is (= (cov + [1 2] [1 3]) [[2 4] [3 5]])
        "square matrix")
    (is (= (cov * [1 2] [3]) [[3] [6]])
        "vector to scalar")
    (is (= (cov str "c" ["a" "b"]) [["ca" "cb"]])
        "scalar to vector")))
