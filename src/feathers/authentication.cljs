(ns feathers.authentication
  (:refer-clojure :exclude [rest])
  (:require [goog.object :as obj]
            [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def auth   (node/require "@feathersjs/authentication"))
(def jwt    (node/require "@feathersjs/authentication-jwt"))
(def local  (node/require "@feathersjs/authentication-local"))

(def hooks
  (merge
    (-> auth
      (obj/get "hooks")
      (js->clj :keywordize-keys true))
    (-> local
      (obj/get "hooks")
      (js->clj :keywordize-keys true))))

(defn configure [app conf]
  (-> app
    (fs/configure (auth conf))
    (fs/configure (jwt))
    (fs/configure (local))))

(defn service [app path]
  (let [svc   (fs/service app path)
        auth  (:authenticate hooks)
        hooks (clj->js {:before {:create [#(.log js/console "auth-hook!") (auth. ["jwt" "local"])]}})]
    (.hooks svc hooks)
    app))
