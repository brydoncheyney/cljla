(defproject cljla "0.1.0-SNAPSHOT"
            :description "Je$us Loves Amerika web application"
            :url "http://www.jesuslovesamerika.co.uk"
            :min-lein-version "2.0.0"
            :dependencies [[org.clojure/clojure "1.7.0"]
                           [org.clojure/tools.logging "0.3.1"]
                           [compojure "1.3.4"]
                           [ring/ring-defaults "0.1.5"]
                           [ring/ring-jetty-adapter "1.3.2"]
                           [enlive "1.1.5"]
                           [environ "1.0.0"]]
            :plugins [[lein-ring "0.8.13"]]
            :ring {:handler cljla.handler/app}
            :profiles {:dev     {:plugins      [[lein-midje "3.1.3"]
                                                [lein-ancient "0.6.7"]
                                                [lein-kibit "0.1.2"]
                                                [jonase/eastwood "0.2.1"]]
                                 :dependencies [[javax.servlet/servlet-api "2.5"]
                                                [ring-mock "0.1.5"]
                                                [midje "1.7.0-beta1"]]}
                       :uberjar {:uberjar-name "cljla.jar"
                                 :main         cljla.core
                                 :aot          :all}})
