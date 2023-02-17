package org.example;

import java.sql.*;
import java.util.Iterator;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.sql.DriverManager.getConnection;

/**
 * Hello world!
 *
 */
public class App {

    static Connection con;




    public static void forInsertion(int a,String b) throws SQLException {

        String query="insert into book_details(book_id,name) values (?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,a);
        st.setString(2,b);
        int count= st.executeUpdate();

        System.out.println(count + " rows has been added");
        st.close();
    }

    public static void toSearch(int n) throws SQLException{
        String query="select name from book_details where  book_id=(?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,n);
       ResultSet s = st.executeQuery();
//        String a=s.getString("name");
//        System.out.println(a+" is there in the Database");
        while (s.next()){
            System.out.println("your book name is"+s.getString("name"));
        }
        st.close();
    }

    public static void deleteBook(int i) throws SQLException{
        String query="delete from book_details where book_id =(?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,i);
        int count = st.executeUpdate();
        System.out.println(count + " row has been deleted");
        st.close();
    }
    public static void allBooks() throws SQLException{
        String query="select book_id,name from book_details";
        Statement s = con.createStatement();
            ResultSet res = s.executeQuery(query);
            while (res.next()) {
                System.out.println(res.getInt("book_id")+":"+res.getString("name"));
            }
            s.close();
        }

    public static void main( String[] args ) throws Exception
    {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url="jdbc:mysql://localhost:3306/library";
//        String userName="monika";
//        String pass ="monika";

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/library";
        String userName="monika";
        String pass ="monika";

        con = getConnection(url,userName,pass);
        System.out.println("Press 1 for Insertion");
        System.out.println("Press 2 to  Search a book");
        System.out.println("Press 3 to delete the book");
        System.out.println("Press 4 to list all the  books");
        Scanner obj =new Scanner(System.in);
        int k= obj.nextInt();
        if(k==1){
            int a;
            System.out.println("Enter the id of  the book");
            a=obj.nextInt();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the name of the book");
            String book = reader.readLine();
            forInsertion(a,book);
        } else if (k==2) {
            int a;
            System.out.println("Enter the id of the book you want to search");
            a=obj.nextInt();
            toSearch(a);

        } else if (k==3) {
            int a;
            System.out.println("Enter the id of the book you want to delete");
            a=obj.nextInt();
            deleteBook(a);

        } else if (k==4) {
            allBooks();
        }
        con.close();
    }
}
