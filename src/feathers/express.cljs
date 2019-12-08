(ns feathers.express
  (:require ["@feathersjs/express" :as exp]))

(defn express [feathers]
  (exp feathers))

(defn static [app]
  (.use app (exp/static (.cwd js/process))))

(defn json [app]
  (.use app (exp/json)))

(defn urlencoded [app]
  (.use app (exp/urlencoded #js{:extended true})))

(defn not-found [app & [opts]]
  (.use app (exp/notFound opts)))

(defn error-handler [app & [opts]]
  (.use app (exp/errorHandler opts)))
