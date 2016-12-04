(ns feathers.rest
  (:refer-clojure :exclude [rest])
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def rest (node/require "feathers-rest"))

(defn configure [app]
  (fs/configure app (rest)))
