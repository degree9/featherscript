(ns feathers.errors
  (:require
    [cljs.nodejs :as node]))

(def error (node/require "@feathersjs/errors"))

(defn not-found [err & [data]]
  (error.NotFound. err data))

(defn conflict [err & [data]]
  (error.Conflict. err data))
