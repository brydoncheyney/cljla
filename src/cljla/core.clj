(ns cljla.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [cljla.handler :as handler]))

(defn -main []
  (run-jetty handler/app {:port 3000}))