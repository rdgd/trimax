(ns trimax.re-frame
  (:require [trimax.navigation :as nav]
            [re-frame.core :as rf]))

(rf/reg-fx ::navigate-fx nav/navigate!)

(rf/reg-event-fx
  ::navigate
  (fn  [_ [_ loc]]
    {::navigate-fx loc}))
