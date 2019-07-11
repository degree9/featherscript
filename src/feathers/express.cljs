(ns feathers.express
  (:require ["@feathersjs/express" :as exp]
            ["express-session" :as exps]))

(defn expressify [feathers]
  (exp feathers))

;;Note: renamed use -> using - to avoid cljs macro conflict
(defn using
  ([app service]
   (.use app service))
  ([app path service]
   (.use app path service)))

(defn static [app]
  (using app (exp/static (.cwd js/process))))

(defn session [app config]
  (using app (exps config)))

(defn json [app]
  (using app (exp/json)))

(defn urlencoded [app]
  (using app (exp/urlencoded #js{:extended true})))
