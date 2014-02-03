(ns incise.layouts.impl.page
  (:require (incise.layouts [core :refer [register]]
                            [utils :refer [repartial
                                           use-layout
                                           deflayout
                                           defpartial]])
            [incise.layouts.impl.base :as base]
            [hiccup.element :refer [link-to]]))

(defpartial header
  "A very basic header partial."
  [{:keys [site-title]} _]
  [:header
   [:h1#site-title (link-to "/" site-title)]])

(deflayout page
  "The default page/post layout."
  []
  (repartial base/header header)
  (use-layout base/base))

(register [:page :post] page)
