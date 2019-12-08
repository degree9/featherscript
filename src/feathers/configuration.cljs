(ns feathers.configuration
  (:require ["@feathersjs/configuration" :as config]))

(defn configure [app & [opts]]
  (.configure app (config opts)))
