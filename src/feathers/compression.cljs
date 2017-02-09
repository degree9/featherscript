(ns feathers.compression
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def compression (node/require "compression"))

(defn using [app]
  (fs/using app (compression)))
