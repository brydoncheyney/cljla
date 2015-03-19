(ns cljla.handler
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cljla.view :as view]
            [cljla.middleware :refer :all]
            [cljla.content :as content]))

(defroutes app-routes
           (GET "/" []
                (view/page (merge content/page->news
                                  {:navigation content/navigation
                                   :articles   content/articles})))
           (GET "/healthcheck" [] "je$us loves you")
           (route/not-found (:content content/page->not-found)))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)
      (wrap-logging)))
