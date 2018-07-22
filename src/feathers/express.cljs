(ns feathers.express
  (:require ["@feathersjs/express" :as express]))

(defn expressify [feathers]
  (express feathers))

;;Note: renamed use -> using - to avoid cljs macro conflict
(defn using
  ([app service]
   (.use app service))
  ([app path service]
   (.use app path service)))

(defn static [app]
  (using app (express/static (.cwd js/process))))

(defn json [app]
  (using app (express/json)))

(defn urlencoded [app]
  (using app (express/urlencoded #js{:extended true})))
