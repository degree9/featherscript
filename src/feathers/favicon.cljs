(ns feathers.favicon
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def favicon (node/require "serve-favicon"))

(defn use [app path]
  (fs/use app (favicon path)))
