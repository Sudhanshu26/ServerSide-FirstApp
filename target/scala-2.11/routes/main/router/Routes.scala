
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sudhanshu/IdeaProjects/Sudhanshu/Sudhanshu_26/conf/routes
// @DATE:Wed Nov 04 18:36:36 IST 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

object Routes extends Routes

class Routes extends GeneratedRouter {

  import ReverseRouteContext.empty

  override val errorHandler: play.api.http.HttpErrorHandler = play.api.http.LazyHttpErrorHandler

  private var _prefix = "/"

  def withPrefix(prefix: String): Routes = {
    _prefix = prefix
    router.RoutesPrefix.setPrefix(prefix)
    
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    ("""GET""", prefix, """controllers.Application.index()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addUser""", """controllers.Application.addUser()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """checkUser""", """controllers.Application.checkUser()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findAll""", """controllers.Application.findAll()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addMessage""", """controllers.Application.addMessage()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findMessage/$username<[^/]+>""", """controllers.Application.findMessage(username:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    controllers.Application.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_addUser1_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addUser")))
  )
  private[this] lazy val controllers_Application_addUser1_invoker = createInvoker(
    controllers.Application.addUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "addUser",
      Nil,
      "POST",
      """""",
      this.prefix + """addUser"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_checkUser2_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("checkUser")))
  )
  private[this] lazy val controllers_Application_checkUser2_invoker = createInvoker(
    controllers.Application.checkUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "checkUser",
      Nil,
      "POST",
      """""",
      this.prefix + """checkUser"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_findAll3_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("findAll")))
  )
  private[this] lazy val controllers_Application_findAll3_invoker = createInvoker(
    controllers.Application.findAll(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "findAll",
      Nil,
      "GET",
      """""",
      this.prefix + """findAll"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_addMessage4_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addMessage")))
  )
  private[this] lazy val controllers_Application_addMessage4_invoker = createInvoker(
    controllers.Application.addMessage(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "addMessage",
      Nil,
      "POST",
      """""",
      this.prefix + """addMessage"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_findMessage5_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("findMessage/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_findMessage5_invoker = createInvoker(
    controllers.Application.findMessage(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "findMessage",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """findMessage/$username<[^/]+>"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Assets_versioned6_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    controllers.Assets.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """GET         /view                controllers.Application.viewProfile()
POST        /login               controllers.Application.login()
GET        /webService          controllers.Application.webService()
 Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
      }
  
    // @LINE:7
    case controllers_Application_addUser1_route(params) =>
      call { 
        controllers_Application_addUser1_invoker.call(controllers.Application.addUser())
      }
  
    // @LINE:8
    case controllers_Application_checkUser2_route(params) =>
      call { 
        controllers_Application_checkUser2_invoker.call(controllers.Application.checkUser())
      }
  
    // @LINE:9
    case controllers_Application_findAll3_route(params) =>
      call { 
        controllers_Application_findAll3_invoker.call(controllers.Application.findAll())
      }
  
    // @LINE:10
    case controllers_Application_addMessage4_route(params) =>
      call { 
        controllers_Application_addMessage4_invoker.call(controllers.Application.addMessage())
      }
  
    // @LINE:11
    case controllers_Application_findMessage5_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_Application_findMessage5_invoker.call(controllers.Application.findMessage(username))
      }
  
    // @LINE:17
    case controllers_Assets_versioned6_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(controllers.Assets.versioned(path, file))
      }
  }
}