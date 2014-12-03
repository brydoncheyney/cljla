(ns cljla.middleware)

(defn wrap-logging
  [app]
  (fn [request]
    (clojure.pprint/pprint request)
    (app request)))