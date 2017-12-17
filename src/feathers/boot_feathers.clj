(ns feathers.boot-feathers
  (:require [boot.core :as boot]
            [degree9.boot-npm :as npm]))

(boot/deftask feathers
  "Download feathers.js npm packages."
  []
  (npm/npm :install
    ["@feathersjs/feathers"
     "@feathersjs/commons"
     "@feathersjs/express"
     "@feathersjs/socketio"
     "@feathersjs/socket-commons"
     "@feathersjs/errors"
     "@feathersjs/configuration"
     "@feathersjs/authentication"
     "@feathersjs/authentication-jwt"
     "@feathersjs/authentication-local"]
    :cache-key ::feathers))
