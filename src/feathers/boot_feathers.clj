(ns feathers.boot-feathers
  (:require [boot.core :as boot]
            [degree9.boot-npm :as npm]))

(boot/deftask feathers
  "Download feathers.js npm packages."
  [f feathers        VAL  str  "Version for feathers package."
   r rest            VAL  str  "Version for feathers-rest package."
   s socketio        VAL  str  "Version for feathers-socketio package."
   e errors          VAL  str  "Version for feathers-errors package."
   m memory          VAL  str  "Version for feathers-memory package."
   a authentication  VAL  str  "Version for feathers-authentication package."
   c configuration   VAL  str  "Version for feathers-configuration package."
   b body-parser     VAL  str  "Version for body-parser package."
   o cors            VAL  str  "Version for cors package."
   z compression     VAL  str  "Version for compression package."
   i serve-favicon   VAL  str  "Version for serve-favicon package."]
   (npm/npm :install
     {:feathers                (:feathers       *opts* "latest")
      :feathers-rest           (:rest           *opts* "latest")
      :feathers-socketio       (:socketio       *opts* "latest")
      :feathers-errors         (:errors         *opts* "latest")
      :feathers-memory         (:memory         *opts* "latest")
      :feathers-authentication (:authentication *opts* "latest")
      :feathers-configuration  (:configuration  *opts* "latest")
      :body-parser             (:body-parser    *opts* "latest")
      :cors                    (:cors           *opts* "latest")
      :compression             (:compression    *opts* "latest")
      :serve-favicon           (:serve-favicon  *opts* "latest")}
     :cache-key ::feathers))
