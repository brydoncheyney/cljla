(ns cljla.core.handler-test
  (:require [midje.sweet :refer [facts fact =>]]
            [ring.mock.request :as mock]
            [net.cgrand.enlive-html :as html]
            [cljla.core.handler :refer :all]))

(defn select [node selector]
  (html/select (html/html-snippet node) [selector]))

(defn has-content?
  [content]
  (fn [node]
    (= (-> node :content first))))

(facts "about routes"
       (fact "route found should return HTTP status code 200"
             (let [response (app (mock/request :get "/"))]
               (:status response) => 200
               (:body response) => "je$us loves amerika"))
       (fact "bootstrap route should return HTTP status code 200"
             (let [response (app (mock/request :get "/bootstrap"))]
               (:status response) => 200
               (-> (:body response) (select [:h1])) => (has-content? "Starter Template for Bootstrap")))
       (fact "route not found should return HTTP status code 404"
             (let [response (app (mock/request :get "not-found"))]
               (:status response) => 404)))

(facts "about templates"
       (fact "bootstrap template function should render title content"
             (-> (page "foo") (select [:title])) => (has-content? "foo")))
