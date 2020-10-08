# Trimax
A simple, batteries included solution for hooking into browser history/navigation intended for use with Clojurescript SPA's.

Trimax has no prescriptions around application routing, and so is compatible with virtually any routing library out there.

Trimax assumes your app is using the `/#/` prefix for all SPA routes.

There are also some convenience re-frame effects and events packaged up in a namespace.

## Usage
`{io.rdgd/trimax {:mvn/version "0.1.0"}}`

An example using Bidi as routing library.

```
(ns test.core
 (:require [trimax.history :as h]
           [bidi.bidi :as bidi]))

(def routes ["/" {"" :home "blog" :blog}])

(defn handle-navigation
 [route-match]
 (println "Do something here, like dispatch a re-frame event"))

(defn match-route [url] (bidi/match-route routes url))

(h/init! #(-> (.-token %) match-route handle-navigation))
```
