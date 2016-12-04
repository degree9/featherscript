(ns feathers.core
  (:require [cljs.nodejs :as node]))

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

(defn use
  ([app service]
    (.use app service))
  ([app path service]
    (.use app path service)))

(defn service
  ([app path]
    (.service app path))
  ([app path service]
    (.service app path service)))
