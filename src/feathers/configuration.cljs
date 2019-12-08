(ns feathers.configuration
  (:require ["@feathersjs/configuration" :as config]))

(defn configuration [app & [opts]]
  (.configure app (config opts)))
