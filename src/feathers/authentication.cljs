(ns feathers.authentication
  (:refer-clojure :exclude [rest])
  (:require [goog.object :as obj]
            [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def auth (node/require "feathers-authentication"))
(def jwt  (node/require "feathers-authentication-jwt"))
(def local  (node/require "feathers-authentication-local"))
(def oauth1  (node/require "feathers-authentication-oauth1"))
(def oauth2  (node/require "feathers-authentication-oauth2"))

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

(defn service [app]
  (let [svc (fs/service app "authentication")
        auth (:authenticate hooks)]
    (doto svc
      (.before #js{:create (auth. ["jwt" "local"])}))
    app))
