(ns cljla.healthcheck
  (:require [ring.util.response :refer [response]]))

(defn healthcheck []
  (response {:alive true}))
