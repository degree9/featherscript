(ns feathers.configuration
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]
            ["@feathersjs/configuration" :as config]))


(defn configure [app]
  (fs/configure app (config)))
