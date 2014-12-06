(ns cljla.middleware
  (:require [clojure.pprint :refer [pprint]]))

(defn wrap-logging
  [app]
  (fn [request]
    (pprint request)
    (app request)))