(ns trimax.history
  (:require [goog.events :as events]
            [goog.history.EventType :as HistoryEventType])
  (:import goog.History))

(defonce history (atom nil))

(defn init!
  "This function accepts a fn which is called whenever a navigation event occurs. It passes the event data along to the supplied function. Returns an atom which refers to an instance of goog.History."
  [callback]
  (reset! history
          (doto (History.)
            (events/listen
              HistoryEventType/NAVIGATE
              (fn  [^js event] (callback event)))
            (.setEnabled true))))
