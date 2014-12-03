(ns cljla.test.handler
  (:require [midje.sweet :refer [facts fact =>]]
            [ring.mock.request :as mock]
            [cljla.test.html-inspectors :refer [select-single has-content?]]
            [cljla.handler :refer :all]))

(facts "about routes"
       (fact "route found should return HTTP status code 200"
             (let [response (app (mock/request :get "/"))]
               (:status response) => 200
               (:body response) => "je$us loves amerika"))
       (fact "bootstrap route should return HTTP status code 200"
             (let [response (app (mock/request :get "/bootstrap"))]
               (:status response) => 200
               (-> (:body response) (select-single [:h1]) :content) =not=> empty?))
       (fact "route not found should return HTTP status code 404"
             (let [response (app (mock/request :get "not-found"))]
               (:status response) => 404)))
