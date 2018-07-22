(ns feathers.errors
  (:require
    [cljs.nodejs :as node]
    ["@feathersjs/errors" :as error]))

(defn not-found [err & [data]]
  (error.NotFound. err data))

(defn conflict [err & [data]]
  (error.Conflict. err data))

(defn general [err & [data]]
  (error.GeneralError. err data))
