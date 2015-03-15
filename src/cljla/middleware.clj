(ns cljla.middleware
  (:require [clojure.tools.logging :as log]))

(defn wrap-logging
  [app]
  (fn [request]
    (log/info request)
    (app request)))