(ns cljla.test.view
  (:require [midje.sweet :refer [facts fact =>]]
            [cljla.test.html-inspectors :refer [select-single has-content?]]
            [cljla.view :refer :all]))

(facts "about templates"
       (fact "bootstrap template function should render content"
             (let [content (page {:title "foo" :header "bar"})]
               (-> content (select-single [:title])) => (has-content? "foo")
               (-> content (select-single [:h1])) => (has-content? "bar"))))
