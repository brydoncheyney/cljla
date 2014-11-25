(ns cljla.core.handler-test
  (:require [midje.sweet :refer [facts fact =>]]
            [ring.mock.request :as mock]
            [cljla.core.handler :refer :all]))

(facts "about routes"
       (fact "route found should return HTTP status code 200"
             (let [response (app (mock/request :get "/"))]
               (:status response) => 200
               (:body response) => "je$us loves amerika"))
       (fact "route not found should return HTTP status code 404"
             (let [response (app (mock/request :get "not-found"))]
               (:status response) => 404)))
