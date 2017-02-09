(ns feathers.core
  (:require [cljs.nodejs :as node]))

(enable-console-print!)

(def feathers (node/require "feathers"))

(defn static [path]
  (.static feathers path))

(defn configure
  [app callback]
  (.configure app callback))

(defn listen
  [app & [port]]
  (.listen app port))

(defn setup
  [app server]
  (.setup app server))

;;Note: renamed use -> using - to avoid cljs macro conflict
(defn using
  ([app service]
    (.use app service))
  ([app path service]
    (.use app path service)))

(defn service
  ([app path]
    (.service app path))
  ([app path service]
    (.service app path service)))
