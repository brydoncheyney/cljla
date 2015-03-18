(ns cljla.test.handler
  (:require [midje.sweet :refer [facts fact => contains]]
            [ring.mock.request :as mock]
            [cljla.test.html-inspectors :refer [select-single has-content?]]
            [cljla.handler :refer :all]))

(def GET (partial mock/request :get))

(def get-request (fn [uri]
                   (app (GET uri))))

(facts "about routes"
       (fact "route not found should return HTTP status code 404"
             (get-request "not-found") => (contains {:status 404}))
       (fact "route found should return HTTP status code 200"
             (get-request "/") => (contains {:status 200 :body "je$us loves amerika"}))
       (fact "bootstrap route should return HTTP status code 200"
             (get-request "/bootstrap") => (contains {:status 200}))
       (fact "bootstrap returns h1 content"
             (-> (:body (get-request "/bootstrap"))
                 (select-single [:h1]) :content) =not=> empty?))
