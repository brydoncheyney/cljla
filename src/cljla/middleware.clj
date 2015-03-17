(ns cljla.middleware
  (:require [clojure.tools.logging :as log]))

(defn wrap-logging
  [handler]
  (fn [request]
    (log/info request)
    (handler request)))