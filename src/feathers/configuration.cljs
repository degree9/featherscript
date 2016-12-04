(ns feathers.configuration
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def configuration (node/require "feathers-configuration"))

(defn configure [app path]
  (fs/configure app (configuration path)))
