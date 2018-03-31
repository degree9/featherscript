(ns feathers.rest
  (:refer-clojure :exclude [rest])
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def rest (node/require "@feathersjs/express/rest"))

(defn configure [app]
  (fs/configure app (rest)))
