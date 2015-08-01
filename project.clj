(defproject appcanary/datomic-statsd-reporter "0.1.1"
  :description "A tiny clojure library that reports datomic metrics to statsd."
  :url "http://github.com/appcanary/datomic-statsd-reporter"
  :license {:name "Apache License Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-statsd "0.3.11"]
                 [environ "1.0.0"]])
