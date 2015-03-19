(ns cljla.test.handler
  (:require [midje.sweet :refer [facts fact => contains]]
            [ring.mock.request :as mock]
            [cljla.test.html-inspectors :refer [select-single has-content?]]
            [cljla.handler :refer :all]))

(def get-request #(app (mock/request :get %)))

(facts "about routes"
       (fact "route not found should return HTTP status code 404"
             (get-request "not-found") => (contains {:status 404 :body "Not Found"}))
       (fact "healthcheck route should return HTTP status code 200"
             (get-request "/healthcheck") => (contains {:status 200 :body "je$us loves you"}))
       (fact "root route should return HTTP status code 200"
             (get-request "/") => (contains {:status 200}))
       (fact "root route returns h1 content"
             (-> (:body (get-request "/"))
                 (select-single [:h1])
                 :content) =not=> empty?))
