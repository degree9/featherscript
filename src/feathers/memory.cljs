(ns feathers.memory
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def memory (node/require "feathers-memory"))

(defn using
  ([app path] (fs/using app path (memory)))
  ([app path conf] (fs/using app path (memory conf))))
