package controllers

import play.api._
import play.api.mvc._
import play.api.data.Forms._
import play.api.data._

import play.api.libs.json._
import json.Formats._

import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._

import models._

object Users extends Controller {

  def dummyUser() = Action { implicit request =>
    User.findByEMail("dummy@somewhere.com").map { user =>
      Ok(Json.toJson(user))
    }.getOrElse(NotFound)
  }

  def userById(id: ObjectId) = Action {
    User.findOneById(id).map { user =>
      Ok(Json.toJson(user))
    }.getOrElse(NotFound)
  }

}
