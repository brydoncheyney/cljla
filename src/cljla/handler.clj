(ns cljla.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cljla.view :as view]
            [cljla.middleware :refer :all]
            [cljla.content :as content]))

(defroutes app-routes
           (GET "/" [] "je$us loves amerika")
           (GET "/bootstrap" []
                (view/page (merge content/page->news
                                  {:navigation content/navigation
                                   :articles   content/articles})))
           (route/not-found (:content content/page->not-found)))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)                         ;; TODO: customise
      (wrap-logging)))
