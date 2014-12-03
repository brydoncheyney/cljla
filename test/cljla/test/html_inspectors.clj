(ns cljla.test.html-inspectors
  (:require [net.cgrand.enlive-html :as html]))

(defn has-content? [content]
  (fn [node]
    (= content (-> node :content first))))

(defn select [node selector]
  (html/select (html/html-snippet node) [selector]))

(defn select-single [node selector]
  (first (select node selector)))