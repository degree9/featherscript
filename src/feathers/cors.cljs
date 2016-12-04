(ns feathers.cors
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def cors (node/require "cors"))

(defn use [app]
  (fs/use app (cors)))
