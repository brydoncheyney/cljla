(ns cljla.test.view
  (:require [midje.sweet :refer [facts fact =>]]
            [cljla.test.html-inspectors :refer [select select-single has-content?]]
            [cljla.view :refer :all]))

(facts "about templates"
       (fact "bootstrap template function should render content"
             (let [content (page {:title "foo"
                                  :header "bar"
                                  :articles [{:title "Article 1"
                                              :content "text here"}
                                             {:title "Article 2"
                                              :content "more text here"}]})]
               (-> content (select-single [:title])) => (has-content? "foo | bar")
               (-> content (select-single [:h1])) => (has-content? "foo")
               (-> content (select [:dl#articles :dt]) count) => 2)))
