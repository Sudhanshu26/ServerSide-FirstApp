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


@Entity
@Table(name = "User")
public class Users {
    @Id
    @Column(name = "Id")
    private Long Id;
    @Column(name = "UserName")
    private String userName;

//    Connection connection = DB.getConnection("Sudhanshu");
//
//    public void query() {
//        try {
//             Statement statement = (Statement) connection.createStatement();
//            statement.execute("SELECT (*) FROM User");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }



    public long getId() {
        return Id;
    }


    public void setId(long id) {
        this.Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public static Model.Finder<Long, Users> find = new Model.Finder<Long, Users>(Long.class,
            Users.class);

    public static Users findByName(String name) {

        return find.where().eq("UserName", name).findUnique();

        }
    public static List<Users> findAllUsers(){
        return Users.find.all();
    }


}
