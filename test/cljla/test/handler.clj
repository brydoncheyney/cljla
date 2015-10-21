(ns cljla.test.handler
  (:require [midje.sweet :refer [facts fact => contains]]
            [ring.mock.request :as mock]
            [ring.util.response :refer [get-header]]
            [cljla.test.html-inspectors :refer [select-single]]
            [cljla.handler :refer :all]))

(def get-request #(app (mock/request :get %)))

(facts "about routes"
       (fact "route not found should return HTTP status code 404"
             (let [response (get-request "not-found")]
               (:status response) => 404
               (:body response) => "Not Found"))

       (fact "healthcheck route should return HTTP status code 200"
             (let [response (get-request "/healthcheck")]
               (:status response) => 200
               (get-header response "content-type") => "application/json"
               (:body response) => "{\"alive\":true}"))

       (fact "root route should return HTTP status code 200"
             (get-request "/") => (contains {:status 200}))

       (fact "root route returns h1 content"
             (-> (:body (get-request "/"))
                 (select-single [:h1])
                 :content) =not=> empty?))
