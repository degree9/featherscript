(ns feathers.compression
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def compression (node/require "compression"))

(defn use [app]
  (fs/use app (compression)))
