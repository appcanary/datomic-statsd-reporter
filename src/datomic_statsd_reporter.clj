(ns datomic-statsd-reporter
  (:require [environ.core :refer [env]]
            [clj-statsd :as s]))

(s/setup (if-let [host (env :statsd-host)]
           host
           "127.0.0.1")
         (if-let [port (env :statsd-port)]
           (Integer. port)
           8125))

(defn report-datomic-metrics-to-statsd [metrics]
  (doseq [[metric-name value] metrics]
    (if (map? value)
      (doseq [[sub-metric-name sub-metric-value] value]
        (s/gauge (str "datomic." (name metric-name) "-" (name sub-metric-name)) sub-metric-value))
      (s/gauge (str "datomic." (name metric-name)) value))))
