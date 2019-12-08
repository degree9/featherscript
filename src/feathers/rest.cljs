(ns feathers.rest
  (:refer-clojure :exclude [rest])
  (:require ["@feathersjs/express/rest" :as rest]))

(defn configure [app & [opts]]
  (.configure app (rest opts)))
