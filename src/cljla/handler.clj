(ns cljla.handler
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [cljla.view :as view]
            [cljla.middleware :refer [wrap-request-logging wrap-json-response-headers]]
            [cljla.content :as content]
            [cljla.healthcheck :refer [healthcheck]]))

(defroutes app-routes
           (GET "/" []
                (view/page (merge content/page->news
                                  {:navigation content/navigation
                                   :articles   content/articles})))
           (GET "/healthcheck" [] (healthcheck))
           (GET "/enqueue" [] {:headers {"Content-type" "plain-text"} :body "enqueuing"})
           (route/not-found (:content content/page->not-found)))

(def app
  (-> app-routes                                            ;    <    response
      (wrap-defaults site-defaults)                         ;    |        |
      (wrap-json-response-headers)                          ;    |        |
      (wrap-json-response)                                  ;    |        |
      (wrap-request-logging)))                              ; request     >
