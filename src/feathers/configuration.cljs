(ns feathers.configuration
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def configuration (node/require "@feathersjs/configuration"))

(defn configure [app]
  (fs/configure app (configuration)))
