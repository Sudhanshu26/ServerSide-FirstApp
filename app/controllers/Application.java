package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import model.ChatMessages;
import model.Users;

import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import scala.util.parsing.json.JSONArray;
import views.html.index;

import java.net.UnknownServiceException;
import java.text.SimpleDateFormat;
import java.util.List;


public class Application extends Controller {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    @BodyParser.Of(BodyParser.Json.class)


    public static Result addUser() {
        ObjectNode result = Json.newObject();
        JsonNode json = request().body().asJson();
        System.out.println("Input to register method :" + json.toString());

        String name = json.findPath("NewAccount_Name").textValue().trim();
        if(  "".equals(name.trim())){
            result.put("Message:","Enter a name");
        }
        Users user = Users.findByName(name);
        if(user!=null){
            result.put("Message:","Username already exist");
            return ok(result);
        }
        user = new Users();
        user.setUserName(name);
        Ebean.save(user);
        result.put("Message:","Username added");


        return ok(result);
    }
    public static Result checkUser() {
        ObjectNode result = Json.newObject();
        JsonNode json = request().body().asJson();
        System.out.println("Input to register method :" + json.toString());

        String name = json.findPath("ExistingAccount_Name").textValue().trim();
        if(  "".equals(name.trim())){
            result.put("Message:","Enter a name");
        }
        Users user = Users.findByName(name);
        if(user==null){
            result.put("Message:","Username does not exist ");
            return ok(result);
        }
//        user = new Users();
//        user.setUserName(name);
//        Ebean.save(user);

        result.put(" Message:","Happy Messaging");


        return ok(result);
    }

    public static Result addMessage(){

        ObjectNode result = Json.newObject();
        JsonNode json = request().body().asJson();
       // System.out.println("Input to register method :" + json.toString());

        String name = json.findPath("From").textValue().trim();
        String reciever_name = json.findPath("To").textValue().trim();

        String message = json.findPath("Message").textValue().trim();
        String date = json.findPath("Date").textValue().trim();

        if(  "".equals(message.trim())){
            result.put("Message:","Enter a message");
        }
       // Users user = Users.findByName(name);
        ChatMessages messages = new ChatMessages();


        messages.setMessageFrom(name);
        messages.setMessage(message);
        messages.setMessageTo(reciever_name);
        messages.setDatetime(date);
        Ebean.save(messages);
        result.put("Message:","Message added");


        return ok(result);
    }


    public static Result findMessage(String username){
        ObjectNode result = Json.newObject();
        JsonNode json = request().body().asJson();

//        String username = json.findPath("To").textValue().trim();
       // result.put("Usename Found",username);
        ChatMessages messages = new ChatMessages();
        List<ChatMessages> list_messages = messages.getMessage(username);
        JsonNode json1 = Json.toJson(list_messages);


        return ok(json1);





    }
//      public static Result sendMessage(){
//          ObjectNode result = Json.newObject();
//          result.put("from",)
//      }







    public static Result findAll(){
      //  ObjectNode result = Json.newObject();
       // JsonNode json = request().body().asJson();

        List<Users> list = Users.findAllUsers();
       JsonNode json = Json.toJson(list);
   //     org.codehaus.jackson.JsonNode json = Json.toJson(list);
        return ok(json);


    }
//    public void save(String name){
//        user1.setUserName(name);
//        Ebean.save(user1);
//        result.put(" Message","Username added");
//    }

//    public static Result addUsername() {
//        ObjectNode result = Json.newObject();
//        JsonNode json = request().body().asJson();
//        System.out.println("Input to register method :" + json.toString());
//
//        String name = json.findPath("NewAccount_Name").textValue().trim();
//        if(  "".equals(name.trim())){
//            result.put("Error Message:","Enter a name");
//        }
////       else{
////            result.put("Verified","Happy Messaging");
////        }
//        Users user1=Users.findByName(name);
//        if(user1==null){
//            Ebean.save(user1);
//            result.put(" Message","Username added");
//        }
//        else{
//            result.put("Error Message","Username already taken");
//        }
////        Users user = new Users();
////        user.setUserName(name);
////        Ebean.save(user);
//
//
//        //  result.put("Success Message", "your response is saved");
//
//        return ok(result);
//    }
//
//    @BodyParser.Of(BodyParser.Json.class)
//    public static Result login() {
//        ObjectNode result = Json.newObject();
//        JsonNode json = request().body().asJson();
//        System.out.println("Input to login method :" + json.toString());
//        String emailId = json.findPath("emailId").textValue();
//        String passwd = json.findPath("password").textValue();
//
//        if (emailId == null || "".equals(emailId.trim())) {
//            result.put("Error Message", "Please enter email first");
//            return badRequest(result);
//        }
//        if (passwd == null || "".equals(passwd.trim())) {
//            result.put("Error Message", "Please enter your password");
//            return badRequest(result);
//        }
//        emailId = emailId.trim();
//        passwd = passwd.trim();
//
//        Users user = Users.findByEmail(emailId);
//
//        if (user == null) {
//            result.put("Error Message", "Please register yourself");
//            return unauthorized(result);
//        } else {
//            String passwordDatabase = user.getPassword();
//            if (Encryption.matchHash(passwd, passwordDatabase)) {
//                String newToken = UUID.randomUUID().toString();
//                user.setAuth_token(newToken);
//                Ebean.update(user);
//                result.put("Success", user.getEmailId());
//                result.put("AUTH_TOKEN", newToken);
//                result.put("Details", "You can view your details and update your profile");
//                return ok(result);
//            } else {
//                result.put("Unauthorised Access", "Please enter correct credentials");
//                return unauthorized(result);
//            }
//
//        }
//    }
//
//
//    @Security.Authenticated(Secured.class)
//    @BodyParser.Of(BodyParser.Json.class)
//    public static Result updateProfile() throws ParseException {
//        ObjectNode result = Json.newObject();
//        JsonNode json = request().body().asJson();
//        System.out.println("Input to update method :" + json.toString());
//
//        Users user = Users.findByAuthToken(request().getHeader("AUTH_TOKEN"));
//        String fname = json.findPath("firstName").textValue();
//        String lname = json.findPath("lastName").textValue();
//        String gender = json.findPath("gender").textValue();
//        String dob = json.findPath("DOB").textValue();
//        Date DOB = null;
//        DOB = sdf.parse(dob);
//        System.out.println("DOB is" + DOB.toString());
//        if (fname == null || "".equals(fname.trim()) || lname == null || "".equals(lname.trim()) || gender == null
//                || "".equals(gender.trim()) || dob == null || "".equals(dob.trim())) {
//            result.put("ErrorMessage", "Please give all the details.Recheck again");
//            return badRequest(result);
//        }
//        fname = fname.trim();
//        lname = lname.trim();
//        gender = gender.trim();
//        dob = dob.trim();
//
//        if (!(gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))) {
//            result.put("ErrorMessage", "Please specify gender as m/f only");
//            return badRequest(result);
//        }
//
//        UsersProfile usersProfile = UsersProfile.findByUser(user);
//        usersProfile.setUser(user);
//        usersProfile.setFirstName(fname);
//        usersProfile.setLastName(lname);
//        usersProfile.setGender(gender);
//        usersProfile.setDOB(DOB);
//        Ebean.update(usersProfile);
//
//        System.out.println("User_Profile firstname is " + usersProfile.getFirstName());
//
//        result.put("SuccessMessage", "Congrats!!!! your profile has been updated");
//        return ok(result);
//    }
//
//
//    @Security.Authenticated(Secured.class)
//    public static Result viewProfile() {
//        ObjectNode result = Json.newObject();
//        Users user = Users.findByAuthToken(request().getHeader("AUTH_TOKEN"));
////        UsersProfile usersProfile = UsersProfile.findByUser(user);
//        UsersProfile usersProfile = user.getUsersProfile();
//        result.put("firstName", usersProfile.getFirstName());
//        result.put("lastName", usersProfile.getLastName());
//        result.put("gender", usersProfile.getGender());
//        result.put("DOB", sdf.format(usersProfile.getDOB()));
//        return ok(result);
//
//    }
//
//    // @Security.Authenticated(Secured.class)
//    public static Result webService() {
//        final F.Promise<WSResponse> wsResponsePromise = WS.url("https://www.google.co.in").get();
//        HttpResponse response=wsResponsePromise.;
//        System.out.println("hi" + wsResponsePromise);
//
//        return ok();
//    }
}
