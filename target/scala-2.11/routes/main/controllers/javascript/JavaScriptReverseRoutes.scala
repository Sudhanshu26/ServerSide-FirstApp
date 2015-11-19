
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sudhanshu/IdeaProjects/Sudhanshu/Sudhanshu_26/conf/routes
// @DATE:Wed Nov 04 18:36:36 IST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:17
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addUser"})
        }
      """
    )
  
    // @LINE:11
    def findMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.findMessage",
      """
        function(username) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findMessage/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username))})
        }
      """
    )
  
    // @LINE:10
    def addMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.addMessage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addMessage"})
        }
      """
    )
  
    // @LINE:8
    def checkUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.checkUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "checkUser"})
        }
      """
    )
  
    // @LINE:9
    def findAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.findAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findAll"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}