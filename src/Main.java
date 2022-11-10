
import CommandLine.*;

public class Main {

    public static void main(String[] args) {
//        if(args.length>=1) {
//            if(args[0].equals("-add")) {
                String[] ar = new String[2];
                ar[0] = "-add";
                ar[1] = "Student";
                AddTeacherCommand.add(ar);
//            }
//        }
//        try {
//            String url="jdbc:mysql://localhost:3306/lab6";
//            String UserName="root";
//            String PassWord="Suprit@123";
//            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lab6","root","Suprit@123");
//            Statement st=con.createStatement();
//            String query="select * from employee;";
//            ResultSet rs  = st.executeQuery(query);
//            while (rs.next())
//            {
//                System.out.println(rs.getString(1));
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
}