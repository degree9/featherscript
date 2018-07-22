(ns feathers.rest
  (:refer-clojure :exclude [rest])
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]
            ["@feathersjs/express/rest" :as rest]))

(defn configure [app]
  (fs/configure app (rest)))
