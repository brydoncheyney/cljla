(defproject cljla "0.1.0-SNAPSHOT"
  :description "Je$us Loves Amerika web application"
  :url "http://www.jesuslovesamerika.co.uk"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/core.async "0.2.374"]
                 [compojure "1.4.0"]
                 [com.stuartsierra/component "0.3.1"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [enlive "1.1.6"]
                 [environ "1.0.2"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler cljla.handler/app}
  :main cljla.core
  :profiles {:dev     {:plugins      [[lein-midje "3.1.3"]
                                      [lein-ancient "0.6.8"]
                                      [lein-kibit "0.1.2"]
                                      [jonase/eastwood "0.2.3"]]
                       :dependencies [[javax.servlet/servlet-api "2.5"]
                                      [ring-mock "0.1.5"]
                                      [midje "1.8.3" :exclusions [commons-codec]]
                                      [commons-codec "1.10"]]}
             :uberjar {:uberjar-name "cljla.jar"
                       :main         cljla.core
                       :aot          :all}})
