package model;

import com.avaje.ebean.Model;
import org.h2.engine.User;
import play.db.DB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
/**
 * Created by sudhanshu on 3/11/15.
 */

@Entity
@Table(name = "chatmessages")


public class ChatMessages {
    @Id
    @Column(name = "Id")
    private Long Id;
    @Column(name = "messagefrom")
    private String messageFrom;
//    @Column(name = "MessageTo")
//    private String messageTo;
    @Column(name = "message")
    private String message;

    @Column(name = "messageto")
    private String messageTo;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Column(name = "DATETIME")
    private String datetime;




    public static Model.Finder<Long, ChatMessages> find1 = new Model.Finder<Long, ChatMessages>(Long.class,
            ChatMessages.class);

   public static List<ChatMessages> getMessage(String username){

       List<ChatMessages> list = find1.where().eq("messageto",username).findList();
       List<ChatMessages> list1 = find1.where().eq("messagefrom",username).findList();
       list.addAll(list1);
       if(list.size()==0)
           return null;

       return list;

   }



    public long getId() {
        return Id;
    }


    public void setId(long id) {
        this.Id = id;
    }

    public String getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(String messageFrom) {
        this.messageFrom = messageFrom;
    }

    public String getMessageTo() {
        return messageTo;
    }

    public void setMessageTo(String messageTo) {
        this.messageTo = messageTo;
    }
//
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
