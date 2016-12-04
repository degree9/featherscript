(ns feathers.express
  (:require [cljs.nodejs :as node]))

(def express (node/require "express"))

(defn options
  ([app opts] (.options app opts))
  ([app path opts] (.options app path opts)))
