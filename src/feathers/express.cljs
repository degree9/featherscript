(ns feathers.express
  (:refer-clojure :exclude [rest])
  (:require ["@feathersjs/express" :as exp]
            ["@feathersjs/express/rest" :as expr]))

(defn express [app]
  (exp app))

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

(defn express-rest [app & opts]
  (.configure app (apply expr opts)))
