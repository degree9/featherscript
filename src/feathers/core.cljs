(ns feathers.core
  (:require [cljs.nodejs :as node]
            ["@feathersjs/feathers" :as feathers]))

(enable-console-print!)

(defn configure
  [app callback]
  (.configure app callback))

(defn listen
  [app & [port]]
  (.listen app port))

(defn setup
  [app server]
  (.setup app server))

(defn service
  ([app path]
   (feathers/service app path))
  ([app path service]
   (feathers/service app path service)))

(defn hooks
 ([app hook]
  (.hooks app (clj->js hook)))
 ([app path hook]
  (.hooks (service app path) (clj->js hook))))
