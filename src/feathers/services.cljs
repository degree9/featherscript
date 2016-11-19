(ns feathers.services
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def rest (node/require "feathers-rest"))

(def service fs/service)

(defn find [service params & [callback]]
  (.find service params callback))

(defn get [service id params & [callback]]
  (.get service id params callback))

(defn create [service data params & [callback]]
  (.create service data params callback))

(defn update [service id data params & [callback]]
  (.update service id data params callback))

(defn patch [service id data params & [callback]]
  (.patch service id data params callback))

(defn remove [service id params & [callback]]
  (.remove service id params callback))

(defn setup [service app path]
  (.setup service app path))
