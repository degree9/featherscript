<p align="center"><img src="/.github/D9 Featherscript.png" alt="d9featherscript" width="550px"></p>

[![Clojars Project](https://img.shields.io/clojars/v/degree9/featherscript.svg)](https://clojars.org/degree9/featherscript)<!-- [![Dependencies Status](https://versions.deps.co/degree9/featherscript/status.svg)](https://versions.deps.co/degree9/featherscript) --> [![Downloads](https://versions.deps.co/degree9/featherscript/downloads.svg)](https://versions.deps.co/degree9/featherscript)
<!---
[![CircleCI](https://circleci.com/gh/degree9/featherscript.svg?style=svg)](https://circleci.com/gh/degree9/featherscript)
--->

ClojureScript layer around Feathers.js.

---

<p align="center">
  <a href="https://degree9.io" align="center">
    <img width="135" src="/.github/logo.png">
  </a>
  <br>
  <b>D9 Featherscript is developed and maintained by Degree9</b>
</p>

---

## Feathers Application

The `feathers.application` namespace is the starting point for all feathers apps. 

```
(ns app.server
  (:require [feathers.application :as feathers]))

(def app (feathers/app))
```

Additionally all of the methods of the feathers app object can be called from the `feathers.application` namespace.
See the [API Docs](https://docs.feathersjs.com/api/application.html) for a full list of methods.

## Feathers Services

Services provide the main application logic for feathers apps, they are JS objects that implement request methods.
Service methods are CRUD methods that can optionally be implemented by a service.

```
(ns app.services)

(defn my-service []
  (reify
    Object
    (find   [this params] ...)
    (get    [this id params] ...)
    (create [this data params] ...)
    (update [this id data params] ...)
    (patch  [this id data params] ...)
    (remove [this id params] ...)))
```

## Feathers Hooks


## Feathers Events

---

<p align="center">
  <a href="https://www.patreon.com/degree9" align="center">
    <img src="https://c5.patreon.com/external/logo/become_a_patron_button@2x.png" width="160" alt="Patreon">
  </a>
  <br>
  <b>Support this and other open-source projects on Patreon!</b>
</p>

---
