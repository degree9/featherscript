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

(defn authenticate
  ([strategies] (authenticate "/authenticate" strategies))
  ([service strategies]
   (let [auth (obj/get auth "authenticate")]
     (auth (clj->js {:service service :strategies strategies})))))

(defn hash-password []
  (let [hash (:hashPassword hooks)]
    (hash. "password")))

(defn protect-password []
  (let [protect (:protect hooks)]
    (protect. "password")))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Authentication Classes ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def AuthenticationService (obj/get auth "AuthenticationService"))

(def JWTStrategy (obj/get auth "JWTStrategy"))

(def LocalStrategy (obj/get auth "LocalStrategy"))

(def ExpressOAuth (obj/get oauth "expressOauth"))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Authentication Services ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn register-jwt [service]
  (doto service
    (.register "jwt" (JWTStrategy.))))

(defn register-local [service]
  (doto service
    (.register "local" (LocalStrategy.))))

(defn authentication [app & {:keys [path] :or {path "/authentication"}}]
  (let [auth (AuthenticationService. app)]
    (.use app path auth)))

(defn authentication-jwt [app & {:keys [path] :or {path "/authentication"}}]
  (let [auth (.service app path)]
    (register-jwt auth)
    app))

(defn authentication-local [app & {:keys [path] :or {path "/authentication"}}]
  (let [auth (.service app path)]
    (register-local auth)
    app))

(defn authentication-oauth [app & {:keys [authService] :or {authService "authentication"}}]
  (.configure app (ExpressOAuth #js{:authService authService})))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
