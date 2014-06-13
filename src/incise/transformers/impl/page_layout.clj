(ns incise.transformers.impl.page-layout
  (:require (incise.transformers [core :refer [register]]
                                 [layout :refer [repartial
                                                 use-layout
                                                 deflayout
                                                 defpartial]])
            [incise.transformers.impl.base-layout :as base-layout]
            [hiccup.element :refer [link-to]]))

(defpartial header
  "A very basic header partial."
  [{:keys [site-title]} _]
  [:header
   [:h1#site-title (link-to "/" site-title)]])

(deflayout page
  "The default page/post layout."
  []
  (repartial base-layout/header header)
  (use-layout base-layout/base))

(register :page-layout page)
