(ns feathers.express
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def express (node/require "@feathersjs/express"))

(defn expressify [feathers]
  (express feathers))

(defn static [app]
  (fs/using app (.static express (.cwd js/process))))

(defn json [app]
  (fs/using app (.json express)))

(defn urlencoded [app]
  (fs/using app (.urlencoded express #js{:extended true})))
