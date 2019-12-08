(ns feathers.authentication
  (:require [goog.object :as obj]
            ["@feathersjs/authentication" :as auth]
            ["@feathersjs/authentication-local" :as local]
            ["@feathersjs/authentication-oauth" :as oauth]))

;; Authentication Hooks ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def hooks
  (merge
    (-> auth
      (obj/get "hooks")
      (js->clj :keywordize-keys true))
    (-> local
      (obj/get "hooks")
      (js->clj :keywordize-keys true))))

(defn authenticate [strategies]
  (let [auth  (obj/get auth "authenticate")]
    (auth (clj->js {:service "/authentication" :strategies strategies}))))

(defn hash-password []
  (let [hash (:hashPassword hooks)]
    (hash. "password")))

(defn protect-password []
  (let [protect (:protect hooks)]
    (protect. "password")))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Authentication Services ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn register-strategies [app]
  (let [svc   (obj/get auth "AuthenticationService")
        jwt   (obj/get auth "JWTStrategy")
        local (obj/get local "LocalStrategy")]
    (doto (svc. app)
      (.register "jwt" (jwt.))
      (.register "local" (local.)))))

(defn authentication [app]
  (let [auth (register-strategies app)
        oauth (obj/get oauth "expressOauth")]
    (-> app
      (.use "/authentication" auth)
      (.configure (oauth #js{:authService "authentication"})))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
