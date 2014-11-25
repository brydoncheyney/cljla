(ns cljla.core.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [cljla.core.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "je$us loves amerika"))))
  
  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
