(ns cljla.test.view
  (:require [midje.sweet :refer [facts fact =>]]
            [cljla.test.html-inspectors :refer [select has-content?]]
            [cljla.view :refer :all]))

(facts "about templates"
       (fact "bootstrap template function should render title content"
             (-> (page "foo") (select [:title])) => (has-content? "foo")))
