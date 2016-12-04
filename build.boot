(defn read-file   [file] (read-string (slurp file)))
(defn get-deps    []     (read-file "./dependencies.edn"))
;(defn get-devdeps []     (read-file "./dev_dependencies.edn"))

(set-env!
 :dependencies   (get-deps)
 :resource-paths #{"src"})

(require
 '[adzerk.bootlaces    :refer :all]
 '[degree9.boot-semver :refer :all]
 '[degree9.boot-semgit :refer :all]
 '[degree9.boot-semgit.workflow :refer :all]
 '[tolitius.boot-check :as check])

(task-options!
 pom    {:project 'degree9/featherscript
         :version (get-version)
         :description "Feathersjs wrapper for ClojureScript."
         :url         "http://github.com/degree9/featherscript"
         :scm {:url "http://github.com/degree9/featherscript"}})

(deftask ci-deps
  "Force CI to fetch dependencies."
  []
  identity)

(deftask tests
  "Run code tests."
  []
  (comp
    (check/with-kibit)
    ;(check/with-yagni)
    (check/with-eastwood)
    (check/with-bikeshed)
    ))

(deftask deploy
  "Build project for deployment to clojars."
  []
  (comp
    (version :minor 'inc :patch 'zero)
    (build-jar)
    (push-release)))

(deftask develop
  "Build project for local development."
  []
  (comp
    (watch)
    (version :no-update true
             :minor 'inc
             :patch 'zero
             :pre-release 'snapshot)
    (build-jar)))
