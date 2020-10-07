(ns trimax.navigation
  (:require [trimax.history :as hist]))

(defn navigate! [loc]
  (if (= (str "#" loc)
         (.-hash js/window.location))
    (doto ^js @hist/history
      (.setEnabled false)
      (.setEnabled true)) ;Hack to trigger callback when navigating to the current page.
    (.setToken ^js @hist/history loc)))
